import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] people = new int[N][2];
		int[] ans = new int[N];
		
		for(int i = 0; i < N; i++)for(int j = 0; j < 2; j++) people[i][j] = sc.nextInt();
		
		Arrays.fill(ans, N);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				//자기 자신오면 계산하지마!
				if(i == j)continue;
				//둘다 높으면 등수내리지마!
				if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) continue;
				ans[i] -= 1;
			}
		}
		for(int i = 0; i < N; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}