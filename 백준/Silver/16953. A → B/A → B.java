import java.io.*;
import java.util.*;

public class Main {

	public static long a , b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		bfs();
	}
	
	public static void bfs() {
		Queue<Long> que = new LinkedList<>();
		que.offer(a);
		int cnt = 1;
		long tmp = 0;
		endWhile:
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i = 0; i < size; i++) {
				tmp = que.poll();
				if(tmp == b) break endWhile;
				if(tmp > b)continue;
				que.offer(tmp * 2);
				que.offer((tmp * 10) + 1);			
			}
			cnt++;
		}
		if(tmp > b)System.out.println(-1);
		else System.out.println(cnt);
	}
}