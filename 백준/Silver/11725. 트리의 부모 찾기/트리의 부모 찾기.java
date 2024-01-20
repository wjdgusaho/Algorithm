import java.util.*;
import java.io.*;

public class Main {
	
	public static int N;
	public static int[] result;
	public static boolean[] visited;
	public static List<Integer>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) graph[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			graph[B].add(A);
		}
		
		result = new int[N+1];
		visited = new boolean[N+1];
		
		bfs();
		StringBuffer sb = new StringBuffer();
		for(int i = 2; i <= N; i++) {
			sb.append(result[i] + "\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs() {
		
		Deque<Integer> que = new ArrayDeque<>();
		que.offer(1);
		visited[1] = true;
		
		while(!que.isEmpty()) {
			int node = que.poll();
		
			for(int tmp :  graph[node]) {
				if(!visited[tmp]) {
					result[tmp] = node;
					que.offer(tmp);
					visited[node] = true;
				}
			}
		}
	}
}