import java.util.*;
import java.io.*;

public class Main {

	public static int N, M;
	//public static ArrayList<int[]>[] graph;
	public static long[][] map;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		//graph = new ArrayList[N + 1];
		map = new long[N+1][N+1];
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++ ) {
				if(i == j) map[i][j] = 0;
				else map[i][j] = Integer.MAX_VALUE;
			}
		}
		
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			map[a][b] = Math.min(map[a][b], w);
		}

		StringBuffer sb = new StringBuffer();
			
	
		for(int mid = 1; mid < N+1; mid++) {
			for(int start = 1; start < N+1; start++) {
				for(int end = 1; end < N+1; end++) {
					map[start][end] = Math.min(map[start][mid]+ map[mid][end], map[start][end]);
				}
			}
		}
		
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < N+1; j++) {
				if(map[i][j] == Integer.MAX_VALUE) sb.append("0 ");
				else sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}