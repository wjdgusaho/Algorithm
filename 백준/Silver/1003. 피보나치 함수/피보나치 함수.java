import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		
		
		for(int n = 0; n < N; n++) {
			
			int num = sc.nextInt();
			//num 값이 0일때
			if(num == 0) {
				System.out.println("1 0");
				continue;
			}
			//num 값이 1일떄
			if(num == 1) {
				System.out.println("0 1");
				continue;
			}
			
			//저장 되는 값 위치 
			//0일 때
			int[] tmp1 = { 1, 0 }; 
			//1일 때 
			int[] tmp2 = { 0, 1 };
			int[] tmp = new int[2];
			for(int i = 2; i <= num; i++) {
				tmp[0] = tmp1[0] + tmp2[0];
				tmp[1] = tmp1[1] + tmp2[1];
				
				// 위치 변경
				tmp1[0] = tmp2[0];
				tmp1[1] = tmp2[1];
				
				tmp2[0] = tmp[0];
				tmp2[1] = tmp[1];
				
			}
			System.out.println(tmp2[0] + " " + tmp2[1]);
		}
	}

}