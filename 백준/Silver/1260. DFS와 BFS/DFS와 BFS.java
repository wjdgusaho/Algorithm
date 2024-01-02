import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, V;
	static boolean[][] map;
	static StringBuffer sb;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][N+1];
		
		int[] tmp = new int[2];
		for(int i = 0; i < M; i++) {
			tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			map[tmp[0]][tmp[1]] = true;
			map[tmp[1]][tmp[0]] = true;
		}
		
		sb = new StringBuffer();
		visited = new boolean[N+1];
		dfs(V);
		visited = new boolean[N+1];
		bfs();
		
		System.out.println(sb);
	}
	
	public static void dfs(int num) {
		sb.append(num + " ");
		visited[num] = true;
		for(int i = 1; i < N+1; i++) {
			if(map[num][i] && !visited[i]) {
				dfs(i);
			}
		}
		return;
	}
	
	public static void bfs() {
		
		Queue<Integer> que = new LinkedList<Integer>();
		//초기값 세팅
		que.offer(V);
		visited[V] = true;
		sb.append("\n"+ V + " ");
		
		while(!que.isEmpty()) {
			int tmp = que.poll();
			for(int i = 1; i < N+1; i++) {
				if(map[tmp][i] && !visited[i]) {
					que.offer(i);
					visited[i] = true;
					sb.append(i + " ");
				}
			}
		}	
	}

}