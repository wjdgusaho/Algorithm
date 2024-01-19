import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			
			if(tmp == 0) {
				if(pq.size() == 0) sb.append("0" +"\n");
				else sb.append(pq.poll() + "\n");
			}
			else {
				pq.offer(tmp);
			}
		}
		System.out.println(sb);
		
	}
}