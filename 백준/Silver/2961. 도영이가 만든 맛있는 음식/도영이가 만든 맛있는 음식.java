import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//재료의 수
		int N = Integer.parseInt(br.readLine());
		//음식의 맛
		int[][] food = new int[N][2];
		
		StringTokenizer st;
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			food[n][0] = Integer.parseInt(st.nextToken());
			food[n][1] = Integer.parseInt(st.nextToken());
		}
		
		int min = 10000000;
		//선택할수 있는 모든 경우의수
		for(int i = 1; i < (1<<N); i++) {
			int tmp = 1;
			int tmp2 = 0;
			for(int j = 0; j < N; j++) {
				if( ( i & (1<<j) ) == 0 ) continue;
				tmp *= food[j][0];
				tmp2 += food[j][1];
			}
			if( Math.abs(tmp2-tmp) < min ) {
				min =  Math.abs(tmp2-tmp);
			}	
		}
		System.out.println(min);
	}
}
