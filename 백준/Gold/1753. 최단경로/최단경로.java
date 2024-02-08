import java.util.*;
import java.io.*;

public class Main {

	public static int V, E, K;
	public static ArrayList<int[]>[] graph;
	public static int[] dist;
	public static StringBuffer sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		dist = new int[V+1];
		
		for(int i = 0; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
			graph[i] = new ArrayList<int[]>();
		}
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] {v, w});
		}
		
		sb = new StringBuffer();
		dijkstra();
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static class Data implements Comparable<Data> {
		int index;
		int cost;
		
		public Data (int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Data o1) {
			return this.cost - o1.cost;
		}
		
	}
	
	public static void dijkstra() {
		
		PriorityQueue<Data> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V + 1];
		pq.offer(new Data(K, 0));
		dist[K] = 0;
		
		while(!pq.isEmpty()) {
			
			Data tmp = (Data) pq.poll();
			if(check[tmp.index]) continue;
			check[tmp.index] = true;
			
			if(dist[tmp.index] > tmp.cost) dist[tmp.index] = tmp.cost;
			
			for(int i = 0; i < graph[tmp.index].size(); i++) {
				int[] nextNode = graph[tmp.index].get(i);
				if(dist[nextNode[0]] > tmp.cost + nextNode[1]) {
					pq.offer(new Data(nextNode[0], tmp.cost + nextNode[1]));
				}
			}
			
		}	
	}
	
}