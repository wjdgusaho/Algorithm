import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];

  
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        if (N == 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(arr);

        int cut = (int) Math.round(N * 15.0 / 100.0);
        int value = N - (cut * 2);

        long sum = 0;

        for (int i = cut; i < N - cut; i++) {
            sum += arr[i];
        }

        double result = (double) sum / value;
        System.out.println(Math.round(result));
	}

}