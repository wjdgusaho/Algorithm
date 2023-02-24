import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] number, inputs;
	static char[] gather = {'a', 'e', 'i', 'o', 'u'};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		 L = Integer.parseInt(st.nextToken());
		 C = Integer.parseInt(st.nextToken());
		
		inputs = br.readLine().replace(" ", "").toCharArray();
		Arrays.sort(inputs);
		
		number = new char[L];
		
		comb(0, 0);
		
	}

	private static void comb(int cnt, int start) {
		
		if(cnt == L) {
			int gatCnt = 0;
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < gather.length; j++) {
					if(number[i] == gather[j]) gatCnt++;
				}
			}
			
			if(gatCnt <= 0) return;
			if(L-gatCnt < 2) return;
			
			for(int i = 0; i < L; i++) {
				System.out.print(number[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < C; i++) {
			number[cnt] = inputs[i];
			comb(cnt+1, i+1);
		}
	}
}