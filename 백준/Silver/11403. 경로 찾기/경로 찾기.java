import java.util.*;
import java.io.*;

public class Main {
	
	public static int N;
	public static int[][] graph;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//i -> j 갈수잇는가를 확인하기위함
		//i -> j 갈수있으면 바로 굳
		//i -> k를 지나서 -> j를 갈수 있는가 ?
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1; 
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(graph[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}