import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(in.readLine());
		int[] arr = new int[T];
		
		for(int t = 0; t < T; t++) {
			arr[t] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < T; i++) {
			wr.write(arr[i]+"");
			wr.newLine();
		}
		wr.close();
		in.close();
		
	}
}
