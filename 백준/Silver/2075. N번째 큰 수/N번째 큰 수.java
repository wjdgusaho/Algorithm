import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 모든 수는 자신의 한칸 위에 있는 수보다 크다
		// N번째 큰수 ?  N이 1 ~ 1500		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans = pq.poll();
		}
		
		System.out.println(ans);
	}
}