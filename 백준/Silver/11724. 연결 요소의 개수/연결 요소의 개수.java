import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, V, cnt;
	public static boolean[][] map;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		
		for(int i = 0; i < V; i++) {
			int[] tmp = new int[2];
			tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			map[tmp[0]][tmp[1]] = true;
			map[tmp[1]][tmp[0]] = true;
		}
		visited = new boolean[N+1];
		cnt = 0;
		for(int i = 1; i < N+1; i++) {
			if(visited[i]) continue;
			bfs(i);			
		}
		System.out.println(cnt);
		
	}

	public static void bfs(int num) {
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(num);
		visited[num] = true;
		
		while(!que.isEmpty()) {
			int tmp = que.poll();
			for(int i = 1; i < N+1; i++) {
				if(map[tmp][i] && !visited[i]) {
					que.offer(i);
					visited[i] = true;
				}
			}
		}
		cnt++;
	}
	
}