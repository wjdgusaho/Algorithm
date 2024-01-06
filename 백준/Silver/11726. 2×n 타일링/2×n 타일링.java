import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long[] dp = new long[N + 1];
		dp[1] = 1;
		if(N == 1) {
			System.out.println(dp[1]);
			return;
		}
		dp[2] = 2;
		if(N == 2) {
			System.out.println(dp[2] % 10007);
			return;
		}
		for(int i = 3; i <= N; i++) {		
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		
		System.out.println(dp[N]);
	}

}