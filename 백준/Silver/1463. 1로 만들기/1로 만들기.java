import java.util.Scanner;

public class Main {

	static int[] memori; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		memori = new int[N+5];
		
		memori[0] = 0;
		memori[1] = 0;
		memori[2] = 1;
		memori[3] = 1;
		
		for(int i = 4; i <= N; i++) {
			memori[i] = fn(i);
		}
		
		System.out.println(memori[N]);
	}
	
	private static int fn(int x) {
		
		if(memori[x] > 0) return memori[x];
		
		int min = Integer.MAX_VALUE;
		if(x%3 == 0) {
			min = Math.min(min ,(1 + memori[x/3]));
		}
		if(x%2 == 0) {
			min = Math.min(min ,(1 + memori[x/2]));
		}
		min = Math.min(min, (1+ memori[x-1]));
	
		return min;
	}

}