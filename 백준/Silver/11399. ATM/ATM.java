import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		
		//System.out.println(Arrays.toString(arr));
		int sum = 0;
		int answer = 0;
		for(int i = 0; i < N; i++) {
			//System.out.println(sum);
			sum = sum + arr[i]; 
			answer += sum;
		}
		System.out.println(answer);
	}
}