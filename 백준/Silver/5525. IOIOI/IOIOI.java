import java.util.*;
import java.io.*;

public class Main {

	public static int N, M;
	public static char[] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = br.readLine().toCharArray();
		find();
	}
	
	public static void find() {
		
		int cnt = 0;
		int result = 0;
		for(int i = 0; i < M-2; i++) {
			
			if(arr[i] == 'I' && arr[i + 1] == 'O' && arr[i + 2] == 'I') {
				cnt++;
			}
			else if(arr[i] == 'I') {
				cnt = 0;
			}
			else;

			if(cnt == N) {
				result++;
				cnt--;
			}
			
		}
		
		System.out.println(result);
	}
}