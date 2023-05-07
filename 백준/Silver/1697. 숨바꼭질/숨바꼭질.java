import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N, K));
		
	}

	private static int bfs(int n, int k) {
		
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(n);
		int level = 0;
		boolean[] visited = new boolean[100002];
		
		ques:
		while(!que.isEmpty()) {
			
			int size = que.size();
			for(int i = 0; i < size; i++ ) {
			
				int tmp = que.poll();
				visited[tmp] = true;
				if(tmp == k) break ques;
				if(tmp-1 >= 0 && !visited[tmp-1]) que.offer(tmp-1);
				if(tmp+1 <= 100000 && !visited[tmp+1]) que.offer(tmp+1);
				if(tmp*2 <= 100000 && !visited[tmp*2]) que.offer(tmp*2);			
			}
			level++;
		}
		return level;	
	}
}