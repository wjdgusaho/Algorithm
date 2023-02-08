import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//카드의 합이 21이 넘지 않는 내에서 최대한 크게 만드는 게임
		// 각 카드에 양의 정수가 
		// N장의 카드를 모두 숫자가 보이도록
		// 딜러는 숫자 M을 외침
		// 제한시간내에 3장 선택
		// M이 넘지 않으면서 최대한 가깝게 
		
		// N장의 카드중 M이 넘지 않으면서 최대한 가까운 3장의 합
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
		int sum = 0;
		int min = 100000000;
		int answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				for(int k = j+1; k < N; k++) {
					sum = arr[i]+arr[j]+arr[k];
					if(M-sum >= 0 && M-sum < min) {
						min = M-sum;
						answer = sum;
					}
				}
			}
		}
		System.out.println(answer);
	}
	
}
