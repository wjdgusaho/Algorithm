import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		int N = sc.nextInt();
		
		int[] arr = new int[K];
		for(int k = 0; k < K; k++) arr[k] = sc.nextInt();
		
		Arrays.sort(arr);
		
		//System.out.println(Arrays.toString(arr));
		
		long start = 1;
		long end = arr[arr.length-1];
		
		//System.out.println(end);
		
		long length = 0;
		
		while(start <= end) {
			long sum = 0;
			long mid = (end-start)/2;
			mid = start+mid;
		
			for(int i = 0; i < K; i++) {
				sum += arr[i]/mid;
			}
			
			//System.out.println(mid + " " + sum + " " + length);
			
			if(sum >= N) {
				if(length < mid) length = mid;
			
				//범위 갱신(max는 유지)
				start  = mid+1;
			}
			else{
				end = mid-1;
			}
		}
		
		System.out.println(length);
	}
	
}