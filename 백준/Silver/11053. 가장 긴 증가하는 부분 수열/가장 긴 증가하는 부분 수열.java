import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N, ans, arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 수열 A 가장 긴 증가하는부분 수열을구하시오
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();	
		int[] check = new int[N];
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			check[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && check[i] < check[j] +1) {
					check[i] = check[j]+1;
				}
			}
			if(max < check[i]) max = check[i];
		}
		System.out.println(max);
	}
	
	
}

/*
private static void subset() {
	
	for(int i = 1; i < (1 << N); i++) {
		int cnt = 0;
		int tmp = 0;
		for(int j = 0; j < N; j++) {
			if( (i & 1 << j) != 0) {
				if(tmp < arr[j]) {
					tmp = arr[j];
					System.out.print(tmp + " ");
					cnt += 1;
				}else {
					break;
				}
			}
		}
		System.out.println();
		ans = Math.max(ans, cnt);
	}
	
}
*/


/*
for(int i = 0; i < arr.length; i++) {
	
	int cnt = 1;
	int start = arr[i];
	
	for(int j = i+1; j < arr.length; j++) {
		if(start < arr[j]) {
			start = arr[j];
			cnt+=1;
		}
	}
	ans = Math.max(cnt, ans);
}
*/