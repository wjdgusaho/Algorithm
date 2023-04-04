import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] number, arr, answer;
	static int NUM;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		NUM = 9;
		arr = new int[NUM];

		for (int i = 0; i < NUM; i++) {
			arr[i] = sc.nextInt();
		}

		// 7곱 난쟁이니간
		number = new int[7];
		comb(0, 0);
	
		Arrays.sort(answer);
		for (int i = 0; i < 7; i++) System.out.println(answer[i]);
			
		

	}
	private static void comb(int start, int cnt) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) sum += number[i];
			if (sum == 100) {
				answer = number.clone();
			}
			return;
		}

		for (int i = start; i < NUM; i++) {
			number[cnt] = arr[i];
			comb(i + 1, cnt + 1);
		}

	}

}