import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			return o2 - o1;
		} );
		
		StringBuffer sb = new StringBuffer();
		
		for(int n = 0; n < N; n++) {
			int tmp = sc.nextInt();
			if(tmp == 0) {
				Integer out = pq.poll();
				sb.append(out != null ? out +"\n" : "0\n"); 
			}
			else {
				pq.offer(tmp);
			}
		}
		System.out.println(sb);	
	}
}