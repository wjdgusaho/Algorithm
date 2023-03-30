import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	
	static Map<String , Integer> map;
	static Deque<Character> deque;
	static int N, K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			char[] arr = br.readLine().toCharArray();
			deque = new ArrayDeque<>();
			map = new HashMap<String, Integer>();
			
			//큐 세팅
			for(char i : arr) deque.offer(i);
			
			//회전(단 같아지면 끝내야한다 이걸 위한 조건이 N/4 만큼 회전할경우 같아진다 - 사각형의 크기 이기떄문)
			
			for(int i = 0; i < N/4; i++) {
				//회전하는 메소드
				rotaition();
				//일떄 값을 구하는 메소드 
				findValue();
			}
			
			//맵을 돌면서 값 가져오기 
			List<Integer> keylist = new ArrayList<>();
			for(String tmp : map.keySet()) {
				keylist.add(map.get(tmp));
			}
			
			Collections.sort(keylist, (a, b)->{
				return b-a;
			});
			
			System.out.println("#"+ t +" "+ keylist.get(K-1));
			
		}
	}
	private static void findValue() {
		
		List<Character> list = new ArrayList<>();
		
		//큐에 값을 다빼서 순서확인
		while(!deque.isEmpty()) {
			list.add(deque.poll());
		}
		
		//순서대로 다시 집어넣는다
		for(char tmp : list) {
			deque.offer(tmp);
		}
		
		//중복처리를 위한 Map 활용
		StringBuffer sb = new StringBuffer();
		int cnt = 1;
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if(cnt == N/4) {
				//맵에 해당값이 없다면 추가하자
				if(!map.containsKey(sb.toString())) {
					map.put(sb.toString(), Integer.parseInt(sb.toString(), 16));
				}
				sb.delete(0, sb.length());
				cnt = 0;
			}
			cnt++;
		}
	}
	
	private static void rotaition() {
		//원형큐
		char tmp = deque.poll();
		deque.offer(tmp);
		
	}

}