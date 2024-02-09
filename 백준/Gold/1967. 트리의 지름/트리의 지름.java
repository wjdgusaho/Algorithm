import java.util.*;
import java.io.*;

public class Main {

	public static int N, result;
	public static ArrayList<int[]>[] graph;
	public static ArrayList<Integer> lastNode;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		result = Integer.MIN_VALUE;
		
		for(int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<int[]>();
		}
		
		StringTokenizer st;
		for(int n = 0; n < N-1; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {b, w});
			graph[b].add(new int[] {a, w});
		}
		
		lastNode = new ArrayList<Integer>();
		for(int i = 1; i < N+1; i++) {
			if(graph[i].size() == 1) lastNode.add(i);
		}
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		for(int node : lastNode) {
			boolean[] visited = new boolean[N+1];
			dfs(node, visited, 0);
		}
		
		System.out.println(result);
		
	}
	
	public static void dfs(int node, boolean[] visited, int cost) {
		if(graph[node].size() == 1 && cost != 0) {
			result = Math.max(cost, result);
			return;
		}
		visited[node] = true;
		
		for(int[] nextNode : graph[node]) {
			if(visited[nextNode[0]]) continue;
			dfs(nextNode[0], visited, cost + nextNode[1]);
		}
	
	}
}