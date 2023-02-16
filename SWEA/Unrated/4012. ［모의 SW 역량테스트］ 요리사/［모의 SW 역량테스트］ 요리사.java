import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] numbers;
	static int[] input;
	static int combCnt = 0 , N, R, comCnt;
	static StringBuffer sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			R = N/2;
			
			int[][] tile = new int[N][N];
			
			StringTokenizer st;
			//입력받기
			for(int r = 0; r < N; r++) {
				 st = new StringTokenizer(br.readLine());
				for(int c= 0; c < N; c++) {
					tile[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			//조합에서 뽑아오기 위한 값 설정
			input = new int[N];
			for(int i = 0; i < N; i++) input[i] += i;
		
			sb = new StringBuffer();
			numbers = new int[R];   
			//조합 ( 한번 한것은 나오면 안됨! )
			comb(0, 0);
			//System.out.println(sb);
			
			String[] strTmp = new String[comCnt];
			
			//System.out.println("comCnt " + comCnt);
			st = new StringTokenizer(sb.toString(), "|");
			for(int i = 0; i < comCnt; i++) strTmp[i] = st.nextToken();
			
			int[] tmp = new int[R];
			
			int min = 10000000;
			
			for(int i = 0; i < comCnt; i++) {
				
				boolean[] visited = new boolean[N];

				int A = 0;
				int B = 0;
				st = new StringTokenizer(strTmp[i].trim());
				//System.out.println(st.toString());
				for(int j = 0; j < R; j++) {
					tmp[j] = Integer.parseInt(st.nextToken());
					//System.out.println("tmp : " + tmp[j]);
					visited[tmp[j]] = true;
				}
				
				for(int j = 0; j < R; j++) {
					for(int k = 0; k < R; k++ ) {
					if(j == k) continue;
						A += tile[tmp[j]][tmp[k]];
					}
				}
	
				//System.out.println(Arrays.toString(tmp));
				
				int tmpCnt = 0;
				for(int j = 0; j < N; j++) {
					if(!visited[j]) {
						tmp[tmpCnt++] = j;
					}
				}
				
				//System.out.println(Arrays.toString(tmp));
				
				for(int j = 0; j<R; j++) {
					for(int k = 0; k < R; k++ ) {
						if(j == k) continue;
						B += tile[tmp[j]][tmp[k]];
					}
				}
				
				//System.out.println("A " + A);
				//System.out.println("B " + B);
				int abs = Math.abs(A-B);
				min = Math.min(abs, min);
				//System.out.println();
				
			}
			System.out.println("#"+t+" "+min);
			comCnt = 0;
			min = 0;
		}
		
		
	}

	private static void comb(int cnt, int start) {
		if(cnt == R) {
			for(int i = 0; i < R; i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append("|");
			comCnt++;
			return;
		}
		
		for(int i = start ; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt+1, i+1);
		}
		
	}
}