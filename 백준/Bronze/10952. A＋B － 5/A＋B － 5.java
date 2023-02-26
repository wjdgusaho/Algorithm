import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = 1, B = 1;
		while(true) {
			A = sc.nextInt();
			B = sc.nextInt();
			if(A+B == 0) break;
			System.out.println(A+B);
		}	
	}
}