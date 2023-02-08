import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] inputs, numbers;
	static StringBuffer sb;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[M];
		inputs = new int[N];
		
		for(int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}
		
		sb = new StringBuffer();
		
		Arrays.sort(inputs);
		perm(0, 0);
		System.out.println(sb);
		
	}

	private static void perm(int cnt, int start) {
		
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(numbers[i]+ " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			perm(cnt+1, i);
		}
		
	}
}
