import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, M, result, s1, s2;
	public static long[][] graph;
	public static int[] numbers;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new long[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++){
				if(i == j)graph[i][j] = 0; 
				else graph[i][j] = Integer.MAX_VALUE; 
			}
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		for(int mid = 1; mid <= N; mid++) {
			for(int start = 1; start <= N; start++) {
				for(int end = 1; end <= N; end++) {
					graph[start][end] = Math.min(graph[start][end], graph[start][mid] + graph[mid][end]);
				}
			}
		}
		
		numbers = new int[2];
		visited = new boolean[N+1];
		result = Integer.MAX_VALUE;
		comb(1, 0);
	
		System.out.println(s1 + " " + s2 + " " + result);
	}
	
	
	public static void comb(int start, int cnt) {
		if(cnt == 2) {
			check();
			return;
		}
		
		for(int i = start; i <= N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = i;
			comb(i, cnt+1);
			visited[i] = false;
		}
		
	}
	
	public static void check() {
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			sum += Math.min(graph[numbers[0]][i], graph[numbers[1]][i]);
		}
		if(result > sum*2 ) {
			result = sum*2;
			s1 = numbers[0];
			s2 = numbers[1];
		}
	}
	
}