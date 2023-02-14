import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(in.readLine());
		Arrays.sort(arr);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < N; i++) {
			sb.append(arr[i] + "\n");
		}
		System.out.println(sb.toString());	
	}
}
