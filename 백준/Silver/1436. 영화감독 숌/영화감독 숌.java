import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		Scanner  sc = new Scanner(System.in);
		int start = 666;
		int cnt = 1;
		int N = sc.nextInt();
		
		while(N != cnt) {
			start += 1;
			if(String.valueOf(start).contains("666")) {
				cnt++;
			}	
		}
		System.out.println(start);
	}
}