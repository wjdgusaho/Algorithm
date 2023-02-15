import java.util.Scanner;

public class Main {

	static int tile[][];
	public static void main(String[] args) {
		
		int NUM = 100;
		tile = new int[NUM][NUM];
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			for(int r = 0; r < 10; r++) {
				for(int c = 0; c <10; c++) {
					tile[(NUM-1)-B-r][(A-1)+c] = 1;
				}
			}
		}
		int sum = 0;
		for(int r = 0; r < NUM; r++) {
			for(int c = 0; c < NUM; c++) {
				sum += tile[r][c]; 
			}
		}		
		System.out.println(sum);
	}
}