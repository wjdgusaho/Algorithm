import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, M, start, end;
	public static int[][] graph;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];
		//인접배열 초기화
		for(int i = 0; i < N+1; i++) {
			for(int j = 0; j < N+1; j++) {
				graph[i][j] = -1;
			}
		}
		
		StringTokenizer st;
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(graph[a][b] != -1) {
				if(graph[a][b] > cost) graph[a][b] = cost;
			}
			else {				
				graph[a][b] = cost;
			}
		}
			
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		if(start == end) System.out.println("0");
		else dijkstra();		
	}
	
	
	public static class Data implements Comparable<Data> {
		int node;
		Long cost;
		
		public Data(int node, Long cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data o) {
			return Long.compare(this.cost, o.cost);
		}
	
	}
	
	public static void dijkstra() {
		
		long[] dist = new long[N+1];
		for(int i = 0; i < N+1; i++) dist[i] = Long.MAX_VALUE;
		PriorityQueue pq = new PriorityQueue<Data>();
		//초기값 세팅
		dist[start] = 0;
		pq.offer(new Data(start, dist[start]));
		
		pq.offer(new Data(start, dist[start]));
		
		while(!pq.isEmpty()) {
			Data tmp = (Data) pq.poll();
			if(dist[tmp.node] < tmp.cost) continue;
			for(int i = 1; i < N+1; i++) {
				if(graph[tmp.node][i] == -1 ) continue;
				long nextCost = dist[tmp.node] + graph[tmp.node][i]; 
				if(dist[i] > nextCost) {
					dist[i] = nextCost;
					pq.offer(new Data(i, nextCost));
				}
			}
		}
		System.out.println(dist[end]);
	}

}