import java.util.*;
import java.io.*;

public class Main {
	
	public static StringBuffer sb;
	public static char[] command;
	public static Deque<String> deque;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		sb = new StringBuffer();
		for(int t = 0 ; t < T; t++) {
			boolean check = true;
			command = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			deque = new ArrayDeque<>();
			
			if(N != 0) {
				for(String tmp : Arrays.asList(br.readLine().replaceAll("\\[|\\]", "").split(","))) {
					deque.offer(tmp);
				}
			}
			else br.readLine();
			
			commendOn();
			
		}
		System.out.println(sb);
	}
	
	public static void commendOn() {
		//커맨드 적용
		boolean reverseState = false;
		for(char com : command) {
			if(com == 'R') {
				reverseState = !reverseState;
			}
			else {
				if(deque.size() == 0) {
					sb.append("error\n");
					return;
				}
				else {
					if(reverseState) deque.pollLast();
					else deque.pollFirst();
				}
			}
		}
		sb.append("[");
		while(!deque.isEmpty()) {
			sb.append(reverseState ? deque.pollLast() : deque.pollFirst());
			if(deque.size() != 0) sb.append(",");
		}
		sb.append("]\n");
	}
}