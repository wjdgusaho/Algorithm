import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long[] arr = new long[5];
		long sum = 0;
		for(int i = 0; i < 5; i++) {
			sum += (long) Math.pow(sc.nextLong(),2);
		}
		System.out.println(sum%10);	
	}
	
}