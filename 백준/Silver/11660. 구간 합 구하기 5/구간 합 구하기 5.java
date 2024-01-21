import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, M;
	public static int[][] map, dpMap;
	public static int[] find;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//입력값
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/* 누적합 구하기
		 * 1 2 3 
		 * 4 5 6
		 * 
		 * 1 3 6
		 * 5 10 19
 		 * 
 		 * 10 = (5+3-1 + 5)
 		 * 19 = (10+6-3 + 6)
		 */
		//초기 세팅
		dpMap = new int[N+1][N+1];
		dpMap[1][1] = map[0][0];

		//가장자리 제외 누적합 구하기
		for(int  r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++ ) {
				dpMap[r][c] = dpMap[r][c-1] + dpMap[r-1][c] + map[r-1][c-1] - dpMap[r-1][c-1];
			}
		}
		
		/* 범위 값 구하기
		 * (2,1) (3,3)
		 * 
		 * dp(3,3) - ( dp(1,3) + dp(3,0) - dp(1,0) );
		 * dp(1, 0)의 경우는 중복되기때문에 빼준다!
		 */
		StringBuffer sb = new StringBuffer();
		for(int m = 0; m < M; m++) {
			find = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) find[i] = Integer.parseInt(st.nextToken());
			
			int exceptSum = 0;
			exceptSum += dpMap[find[0]-1][find[3]];
			exceptSum += dpMap[find[2]][find[1]-1];
			exceptSum -= dpMap[find[0]-1][find[1]-1];

			sb.append(dpMap[find[2]][find[3]] - exceptSum + "\n");
		}
		System.out.println(sb);
	}
	
}