import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int x, time;

		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;

		}
	}

	static int N, K, ans;
	static boolean[] conting;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		ans = 0;
		conting = new boolean [100001];
		
		bfs();

		System.out.println(ans);
	}

	private static void bfs() {

		PriorityQueue<Node> pq = new PriorityQueue<>();

		// 초기 세팅
		pq.offer(new Node(N, 0));

		while (!pq.isEmpty()) {
			
			Node tmp = pq.poll();
			//해당위치 방문 처리
			conting[tmp.x] = true;
			// while 종료 조건 (해당위치에 오면 끝내라!)
			//System.out.println(tmp.x + " " + tmp.time);
			if (tmp.x == K) {
				ans = tmp.time;
				break;
			}
			
			if(tmp.x >= 0 && tmp.x <= 100000) {
				// +1 할 경우
				if(tmp.x + 1 <= 100000 && !conting[tmp.x+1]) {
					pq.offer(new Node(tmp.x + 1, tmp.time + 1));
				}
				// -1 할 경우
				if(tmp.x - 1 >= 0 && !conting[tmp.x-1]) {
					pq.offer(new Node(tmp.x - 1, tmp.time + 1));
				}
				// *2 할 경우
				if(tmp.x *2 <= 100000 && !conting[tmp.x * 2]) {
					pq.offer(new Node(tmp.x * 2, tmp.time));
				}
			}
		}
	}
}