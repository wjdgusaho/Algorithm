import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		for(int i = 1; i < N+1; i++) { 
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N+1];
		
		dp[1] = arr[1];
		if(N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		/*
		 *  마지막 기준 i 라고 본다면 최대값에 두가지 경우수가 존재
		 *  i + (i-1) + (i-3 <- 이전 최대값)  <- 2개가 연속이면안됨!
		 *  i + (i-2 <- 이전 최대값 )
		 */
		if(N >= 3) {
			for(int i = 3; i < N+1; i++) {
				dp[i] = Math.max( arr[i]+arr[i-1]+dp[i-3] , arr[i]+dp[i-2]);
			}
		}
		System.out.println(dp[N]);
	}
}