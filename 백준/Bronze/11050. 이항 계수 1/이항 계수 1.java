import java.util.Scanner;

public class Main {
	
	public static int Fac(int a) {
		if(a==0) return 1;
		else return a * Fac(a-1);
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int K = in.nextInt();
		
		int answer = Fac(N) / (Fac(K)*Fac(N-K));
		
		System.out.println(answer);
	}
}

