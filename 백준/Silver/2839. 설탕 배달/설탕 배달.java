import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		int mins = Integer.MAX_VALUE;
		// 5 비교
		// 3 비교
		int cnt = 1;
		
		//맨처음 5가 0개일때
		if(N%3 == 0) mins = N/3; 
		
		//그외
		while(N-(5*cnt) >= 0) {
		   int Ntmp = N-(5*cnt);
		   
		   if(Ntmp%3 == 0) {
			  mins = Math.min((cnt + (Ntmp/3)), mins);
		   } 
		   cnt++;
		}
		if(mins == Integer.MAX_VALUE) mins = -1;
		System.out.println(mins);	
	}
}