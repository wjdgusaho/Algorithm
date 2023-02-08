import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int M, N;
	static int[] numbers, inputs;

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		M = in.nextInt();
		N = in.nextInt();
		
		numbers = new int [N];
		inputs = new int[M];
		
		for(int i = 0; i < M; i++) {
			inputs[i] = i+1;
		}
		perm(0, 0);
	}

	private static void perm(int cnt, int start) {
		
		if(cnt == N ) {
			for(int i = 0; i < N; i++) {
				System.out.print(numbers[i] +" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < M; i ++) {
			numbers[cnt] = inputs[i];
			perm(cnt+1, i+1);
		}
	}
}
