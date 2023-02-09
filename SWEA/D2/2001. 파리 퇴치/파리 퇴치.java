import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] tile;
	static int N , M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int t = 0; t < T; t++) {
	
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			tile = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					tile[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for(int i = 0; i <= N-M; i++) {
				for(int j = 0; j <= N-M; j++) {
					/*
					 int tmp = sums(i,j,0,0);
					 if(max < tmp) max = tmp; 
					 */
					int tmp = 0;
					for(int r = 0; r < M; r++) {
						for(int c = 0; c < M; c++) {
							 tmp += tile[i+r][j+c];
						}
					}
					if(max < tmp) max = tmp;
				}
			}
			System.out.printf("#%d %d\n",t+1, max);	
		}	
	}
	/*
	private static int sums(int i, int j, int cnt, int tileSum) {
		
		if (cnt >= M*M) {
			return tileSum;
		}
		
		for(int c = 0; c < M; c++ ) {
			tileSum += tile[i][j+c];
			cnt += 1;
		}
		
		return sums(i+1, j, cnt, tileSum);
	}
	*/
}
