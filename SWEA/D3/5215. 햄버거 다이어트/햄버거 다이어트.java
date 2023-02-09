import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t = 0; t < T; t++ ) {
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[] S = new int[N];
			int[] K = new int[N];
			
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				S[n] = Integer.parseInt(st.nextToken());
				K[n] = Integer.parseInt(st.nextToken());
			}
			
			int sMax = -1000000;
			//경우의 수!
			for(int i = 0; i < (1<<N); i++) {
				int tmp = 0;
				int kTmp = 0;
				//한번에 비교할 갯수만큼의 수
				for(int j = 0; j < N; j++) {
					if( (i & (1<<j)) == 0 ) continue;
					kTmp += K[j];
					tmp += S[j];					
				}
				
				if(tmp > sMax && kTmp <= L) {
					sMax = tmp;
				}
			}
			System.out.printf("#%d %d\n", t+1 , sMax);	
		}
	}
}
