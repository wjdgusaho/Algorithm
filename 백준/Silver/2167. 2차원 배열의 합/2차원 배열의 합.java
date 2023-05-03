import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		int[][] kcnt = new int[K][4];
		
		for(int i = 0; i < K; i ++) kcnt[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	
		StringBuffer sb = new StringBuffer();
		for(int k = 0; k < K; k++) {
			int sum = 0;
			for(int i = kcnt[k][0]; i <= kcnt[k][2]; i++) {
				for(int j = kcnt[k][1]; j <= kcnt[k][3]; j++) {
					sum += map[i][j];
				}
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb.toString());
	}

}