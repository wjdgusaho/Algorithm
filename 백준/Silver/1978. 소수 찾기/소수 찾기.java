import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[] arr = new int[N];
		
		for(int n = 0; n < N; n++) arr[n] = in.nextInt();
	
		Arrays.sort(arr);
		int max = arr[arr.length-1];
		
		boolean[] tmp = new boolean[max+1]; 
		//false 를 소수로 가정
		//1은 소수가 아니다!
		tmp[0] = true;
		tmp[1] = true;
		
		for(int i = 2; i < max+1; i++) {
			if(tmp[i]) continue;
			
			for(int j = i; j < max+1; j += i) {
				if(j == i)continue;
				tmp[j] = true;
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(!tmp[arr[i]]) cnt++; 
		}
		System.out.println(cnt);
	}
}
