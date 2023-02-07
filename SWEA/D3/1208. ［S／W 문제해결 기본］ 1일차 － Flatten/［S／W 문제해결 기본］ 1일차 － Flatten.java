import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	
	static int dum;
	static int maxIdx;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//StringBuffer sb = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 0; t < 10; t++) {
			dum = Integer.parseInt(br.readLine());
			String str = br.readLine();
		
			String[] strArr = str.split(" ");
			maxIdx = strArr.length;
			int[] intArr = new int[maxIdx];
			
			for(int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i]);
			}
			System.out.printf("#%d %d\n",t+1, dumf(intArr, 0));
		}
	}

	private static int dumf(int[] intArr, int cnt) {
		
		Arrays.sort(intArr);
		if(cnt == dum) return intArr[maxIdx-1] - intArr[0];
		if(intArr[maxIdx-1] - intArr[0] == 0)return 0;
		
		intArr[maxIdx-1] -= 1;
		intArr[0] += 1;
		
		return dumf(intArr, cnt+1);
	}
	
}
