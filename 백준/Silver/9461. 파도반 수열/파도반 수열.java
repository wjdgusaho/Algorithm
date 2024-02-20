import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] result = new int[T];
		int Max = 0;
		for(int t = 0; t < T; t++) {
			result[t] = sc.nextInt();
			Max = Math.max(result[t], Max);
		}
		
		long[] dp = new long[Max+1];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for(int i = 4; i < Max+1; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		StringBuffer sb = new StringBuffer();
		for(int t = 0; t < T; t++) {
			sb.append(dp[result[t]] +"\n");
		}
		System.out.println(sb);
	}

}