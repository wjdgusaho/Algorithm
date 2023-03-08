import java.util.Scanner;

public class Main {

	static public boolean decimal(int num) {
		for(int j = 2; j*j<= num; j++) {
			if(num%j == 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i = M; i <= N; i++) {
			if(i == 1) continue;
			if(decimal(i)) System.out.println(i);
		}
	}
}