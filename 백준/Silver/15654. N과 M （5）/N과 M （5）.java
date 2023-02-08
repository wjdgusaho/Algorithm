import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int M, N;
	static int[] numbers, inputs;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		numbers = new int[N];
		inputs = new int[M];
		visited = new boolean[M];

		for (int i = 0; i < M; i++) {
			inputs[i] = sc.nextInt();
		}

		Arrays.sort(inputs);

		perm(0, 0);

	}

	private static void perm(int cnt, int start) {

		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		

		for (int i = start; i < M; i++) {
			if(visited[i])continue;
			
			numbers[cnt] = inputs[i];
			visited[i] = true;
			perm(cnt + 1, start);
			visited[i] = false;
			
		}
	}
}
