import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		int R = Integer.parseInt(br.readLine());
		
		Deque<Integer> que = new ArrayDeque<>();
		
		for(int i = 0; i < R; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);

		}
		
		/*
		for(int i = 0; i < N; i++) {
			System.out.print(i + " : ");
			for(int a : list[i]) {
				System.out.print(a + " | ");
			}
			System.out.println();
		}
		*/
		
		boolean[] visited = new boolean[N+1];
		
		//1번이 감염
		que.offer(1);
		
		while(!que.isEmpty()) {
			
			int pop = que.pop();
			//방문 처리
			visited[pop] = true;
			
			for(int i = 0; i < list[pop].size(); i++ ) {
				int tmp = list[pop].get(i);
				//방문 하지 않았다면
				if(visited[tmp]) continue;
				que.push(tmp);
			}
		}
		
		int cnt = 0;
		for(int i = 1; i < N+1; i++) {
			if(visited[i]) cnt++;
		}
		
		//System.out.println(Arrays.toString(visited));
		//1번이 감염시킨 갯수를 구하는거니 자기자신은 빼야한다!
		System.out.println(cnt-1);
		
		
	}
}