import java.io.*;
import java.util.*;

public class Main {

	public static StringBuffer result;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		result = new StringBuffer();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Start = Integer.parseInt(st.nextToken());
			int End = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[10002];
			bfs(Start, End, visited);
			
		}
		System.out.println(result);
	}
	
	public static class Data {
		int num;
		String sb;
		public Data(int num, String sb) {
			this.num = num;
			this.sb = sb;
		}
	}
	
	public static void bfs(int Start, int End, boolean[] visited) {
		
		Queue<Data> que = new ArrayDeque<>();
		int num = Start;
		que.offer(new Data(num, ""));
		
		while(num != End) {
			Data tmp = (Data) que.poll();
			num = tmp.num;
			if(visited[num])continue;
			visited[num] = true;
			//System.out.println(num + " " + tmp.sb);
			if(num == End) {
				result.append(tmp.sb + "\n");
				return;
			}	
			//n*2
			que.offer(twoMul(num,  tmp.sb));
			//n-1
			que.offer(ownMinus(num, tmp.sb));
			//왼쪽 쉬프트
			que.offer(leftShift(num, tmp.sb));
			//오른쪽 쉬프트
			que.offer(rightShift(num, tmp.sb));
		}
	}
	
	public static Data leftShift(int num, String sb) {
		num = num / 1000 + num % 1000 * 10;
		return new Data(num, sb+"L");
	}
	
	public static Data rightShift(int num, String sb) {
		num = num % 10 * 1000 + num / 10;
		return new Data(num, sb+"R");
	}
	
	public static Data ownMinus(int before, String sb) {
		if(before -1 == -1) {
			return new Data(9999, sb+"S");
		}
		else {
			return new Data(before-1, sb+"S");
		}
	}
	
	public static Data twoMul(int before, String sb) {		
		if(before*2 > 9999) {
			return new Data((before*2)%10000, sb+"D");
		}
		else {
			return new Data(before*2, sb+"D");
		}
	}
	
}