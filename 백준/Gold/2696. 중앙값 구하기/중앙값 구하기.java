import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			
			int cnt = N/10;
			if(N%10 > 0) cnt += 1;
			
			int idx = 0;
			for(int i = 0; i < cnt; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					arr[idx++] = Integer.parseInt(st.nextToken());
				}
			}
			//System.out.println(Arrays.toString(arr));
			check();
		}
		
	}
	private static void check() {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}});
		
		StringBuffer sb = new StringBuffer();
		int allCnt = 0;
		int cnt = 0;
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			
			pq.offer(arr[i-1]);
			
			if(i%2==0) continue; //짝수는 날려라
			
			//pq큐 -> que
			int queSize = pq.size()/2;
			for(int j = 0; j < queSize; j++) {
				que.offer(pq.poll());
			}
			
			int tmp = pq.poll();
			pq.offer(tmp);
			sb.append(tmp + " ");
			
			cnt++;
			allCnt++;
			if(cnt == 10) {
				cnt = 0;
				sb.append("\n");
			}
			
			while(!que.isEmpty()) {
				pq.offer(que.poll());
			}
			
		}
		System.out.println(allCnt);
		System.out.println(sb.toString());
	}
}