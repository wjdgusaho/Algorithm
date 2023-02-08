import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] numbers, inputs;
	static int T , P;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = 9;
		P = 7;
		numbers = new int[P];
		inputs = new int[T];
		
		for(int t = 0; t < T; t++) {
			inputs[t] = Integer.parseInt(br.readLine());
		}
		
		combi(0, 0);
	}

	private static void combi(int cnt, int start) {
		
		if(cnt == P) {
			int sum = 0;
			for(int i = 0; i < P; i++) {
				sum += numbers[i];
			}
			if(sum == 100) {
				for(int i = 0; i < P; i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		
		for(int i = start; i < T; i ++) {
			numbers[cnt] = inputs[i];
			combi(cnt+1, i+1);
		}
	}
}
