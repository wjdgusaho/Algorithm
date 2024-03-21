import java.util.*;
import java.io.*;

public class Main {

	public static int N, M, X;
	public static ArrayList<int[]>[] graph;
	public static int[] dist, result;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		result = new int[N+1];
		dist = new int[N+1];
		for(int i = 0 ; i < N+1; i++) {
			graph[i] = new ArrayList<int[]>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, w});
		}
		
		for(int i = 1; i < N+1; i++) {
			dijkstra(i);
			if(i == X){
				for(int j = 1; j < N+1; j++) {
					result[j] += dist[j];
				}
			}
			else {
				result[i] += dist[X];
			}
		}
		
		int maxResult = 0;
		for(int i = 1; i < N+1; i++) {
			if(result[i] == Integer.MAX_VALUE) continue;
			maxResult = Math.max(maxResult, result[i]);
		}
		System.out.println(maxResult);
	}
	
	public static class Data implements Comparable<Data>{
		int index;
		int cost;
		
		public Data(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data o) {
			return this.cost - o.cost;
		}
		
	}
	
	private static void dijkstra(int start) {
		// TODO Auto-generated method stub
		for(int i = 0; i < N+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Data> pq = new PriorityQueue<>();
		boolean[] check = new boolean[N+1];
		pq.offer(new Data(start, 0));
		dist[start] = 0;
		
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