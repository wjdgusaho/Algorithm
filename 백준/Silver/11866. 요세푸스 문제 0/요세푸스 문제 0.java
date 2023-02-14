import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			que.offer(i);
		}
		
		StringBuffer sb = new StringBuffer();
		
		while(que.size() > 0) {
			for(int i = 1; i < K; i++) {
				int tmp = que.poll();
				que.offer(tmp);
			}
			sb.append(que.poll() + ", ");
		}
		System.out.println("<"+ sb.toString().substring(0, sb.toString().length()-2) +">");
	
	}
}
