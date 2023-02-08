import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] sums = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		//0번쨰도 사용 ! 뺼대 아
		for(int i = 1; i < N+1; i++) {
			arr[i-1] = Integer.parseInt(st.nextToken());
			sum += arr[i-1];
			sums[i] = sum;
		}
		
		for(int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			if(i == j) {
				System.out.println(arr[i-1]);
			}else {
				System.out.println(sums[j]-sums[i-1]);
			}
		}	
	}
	
}
