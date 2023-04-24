import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	/*
	 *  + - x / 순
	 * 
	 */
	
	static int N, arr[], oper[];
	static int max, min;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		oper = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		dfs(arr[0], 0);
		
		System.out.println(max);
		System.out.println(min);
	
	}
	
	private static void dfs(int num, int idx) {
		
		if(N-1 == idx) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		
		for(int i = 0; i < 4; i++) {
			if(oper[i] > 0) {

				oper[i]--;
				
				if(i == 0)dfs(num + arr[idx+1], idx+1);
				if(i == 1)dfs(num - arr[idx+1], idx+1);
				if(i == 2)dfs(num * arr[idx+1], idx+1);
				if(i == 3)dfs(num / arr[idx+1], idx+1);
				
				oper[i]++;
			}
		
		}
		
	}
}