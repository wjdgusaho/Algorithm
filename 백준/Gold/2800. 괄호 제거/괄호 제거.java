import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {
	
	static List<int[]> list;
	static Set<String> set;
	static boolean[] visited;
	static char[] arr;
	public static void main(String[] args) throws IOException{
	
		//식에서 쌍에서 맞는 괄호를 뺄경우 나올수 있는 모든 경우의 수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr  = br.readLine().toCharArray();
		list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		
		//괄호 쌍의 인덱스  위치 찾기 
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == '(') {
				//시작한 해당 인덱스 값 넣기
				stack.push(i);
			}
			if(arr[i] == ')') {
				list.add(new int[] {stack.pop(), i});
			}
		}
		
		/*
		//list에 값이 잘 들어갔는지 출력해보기
		for(int[] tmp : list) {
			System.out.println(Arrays.toString(tmp));
		}
		*/
		
		//부분집합을 위한 사용중인지 아닌지 확인을 위한 visited
		visited = new boolean[list.size()];
		//set (부분집합으로 나온값이 중복일수도 있기때문 )
		set = new HashSet<>();
	
		subset(0);
		
		//set값을 List 타입으로 변환 (사전식으로 정렬 하기위해)
		List<String> anList = new ArrayList<>(set);
		//정렬
		Collections.sort(anList);
		
		//결과 출력
		for(String tmp : anList) {
			System.out.println(tmp);
		}
	
	}
	
	private static void subset(int cnt) {
		
		if(cnt == list.size()) {
			
			//아무것도 선택안한 경우 제외
			int falseCnt = 0;
			for(int i = 0; i < list.size(); i++) {
				if(!visited[i]) falseCnt++;
			}
			if(falseCnt == list.size()) return;
 			
			StringBuffer sb = new StringBuffer();
			//배열 복제
			char[] copyStr = arr.clone();
			for(int i = 0; i < list.size(); i++) {
				//if(visited[i])System.out.print(i +" ");
				if(visited[i]) {
					copyStr[list.get(i)[0]] = ' ';
					copyStr[list.get(i)[1]] = ' ';
				}
			}
			//빈칸이 아니면 sb에 추가
			for(int i = 0; i < copyStr.length; i++) {
				if(copyStr[i] != ' ')sb.append(copyStr[i]);
			}
			//완성된 정답 set에 추가 (자동 중복체크)
			set.add(sb.toString());
			//System.out.println();
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1);
		visited[cnt] = false;
		subset(cnt+1);
		
	}
	
}