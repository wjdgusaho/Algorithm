import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//문자열 S가 주어졌을때, 이 문자열에서 단어만 뒤집으려고한다
		//문자열 S는 아래와 같은 규칙
		
		//알파벳 소문자  a ~ z 
		//숫자 0 ~ 9 
		//공백
		// < > 로 이루어져있다 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		char[] tmp = br.readLine().toCharArray();	
		
		StringBuffer sb = new StringBuffer();
		boolean flag = true;
		for(int i = 0; i < tmp.length; i++) {
			
			if(tmp[i] == '<') {
				//기존에 있던값 출력하기
				System.out.print(sb.reverse());
				//sb 값 초기화
				sb = new StringBuffer();
				sb.append(tmp[i]);
				//'>' 일떄까지 확인
				flag = false;
			}
			else if(tmp[i] == '>') {
				//자기 자신까지 추가한후 출력
				sb.append(tmp[i]);
				System.out.print(sb);
				//sb값 초기화
				sb = new StringBuffer();
				flag = true;				
			}
			else if(tmp[i] == ' ' && flag) {
				//flag도 true인데 공백이 나왔어?
				System.out.print(sb.reverse() +" ");
				sb = new StringBuffer();
			}else if(i == tmp.length-1) {
				sb.append(tmp[i]);
				System.out.print(sb.reverse() +" ");
			}else {
				sb.append(tmp[i]);
			}			
		}
	
		/*
		// 이전에 했었던 방법
		tmp = tmp.replace("<", " <");
		tmp = tmp.replace(">", "> ");
		String[] arr = tmp.trim().split(" ");
		
		for(int i = 0; i < arr.length;  i++) {
				
			if(arr[i].contains("<") && arr[i].contains(">")) {
				System.out.print(arr[i]);
			}else if(arr[i].contains("<")){
				System.out.print(arr[i]+" ");
			}else if(arr[i].contains(">")) {
				System.out.print(arr[i]);
			}else {
				StringBuffer sb = new StringBuffer();
				sb.append(arr[i]);
				if(i != arr.length-1 && arr[i+1].contains("<")) {
					System.out.print(sb.reverse());
				}else {
					System.out.print(sb.reverse()+" ");
				}
			}
		}
		*/	
	}
}