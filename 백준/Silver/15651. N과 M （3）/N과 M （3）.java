import java.io.BufferedWriter;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[] numbers, inputs;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		//숫자 갯수
		N = in.nextInt();
		//선택하는 갯수
		M = in.nextInt();
		//선택한 값이 들어갈 배열
		numbers = new int[M];
		//입력한 값의 배열
		inputs = new int[N];
		//숫자 추가
		for(int i = 0; i < N; i++) {
			inputs[i] = i+1;
		}
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if(cnt >= M) {
			for(int i = 0 ; i < M; i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			//numbers에 visited값 
			numbers[cnt] = inputs[i];
			perm(cnt + 1);
		}	
	}
}
