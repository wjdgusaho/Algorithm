import java.util.*;
import java.io.*;

public class Main {

	public static int[][] graph, dp;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		dp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = 0;
			while(st.hasMoreTokens()) {
				graph[i][cnt++] = Integer.parseInt(st.nextToken());
			}
		}
		
		//dp[r][c] = graph[r][c] + dp[r-1][c-1];  왼쪽위
		//dp[r][c] = graph[r][c] + dp[r-1][c];    바로위
		dp[0][0] = graph[0][0];
		for(int r = 1; r < N; r++) {
			for(int c = 0; c < r+1; c++) {
				if(c == 0) {
					dp[r][c] = graph[r][c] + dp[r-1][c];
				}
				else {
					int a = graph[r][c] + dp[r-1][c];
					int b = graph[r][c] + dp[r-1][c-1]; 
					dp[r][c] = Math.max(a, b);
				}
			}
		}
		
		int maxNum = 0;
		for(int i = 0; i < N; i++) {
			maxNum = Math.max(dp[N-1][i], maxNum);
		}
		System.out.println(maxNum);
	}
}