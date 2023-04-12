import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static List<int[]> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		list = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					list.add(new int[] { i, j });
			}
		}

		// 익은 토마토와 안익은 토마토가 있따
		// 하루가 지나면 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향 받는다
		// 하나의 토마토의 인접하곳은 (왼 오 앞 뒤 ) 네 방향에 있는 토마토
		// 대각선 방향 영향 X
		// 토마토가 혼저 익지는 않는다
		// 몇일이 지나면 다 익게 되는지 최소일수를 알고싶다.

		System.out.println(bfs());

	}

	private static int bfs() {

		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };

		boolean visited[][] = new boolean[N][M];
		Deque<int[]> que = new ArrayDeque<int[]>();

		// 초기값 세팅
		for (int[] tmp : list) {
			que.offer(new int[] { tmp[0], tmp[1] });
			visited[tmp[0]][tmp[1]] = true;
		}

		int level = 0;

		while (!que.isEmpty()) {

			int size = que.size();
			
			for (int s = 0; s < size; s++) {

				int tmp[] = que.poll();

				for (int i = 0; i < 4; i++) {
					int nr = tmp[0] + dr[i];
					int nc = tmp[1] + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == -1)continue;
					visited[nr][nc] = true;
					map[nr][nc] = 1;
					que.offer(new int[] {nr, nc});
				}

			}
			level++;
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 || map[i][j] == -1)cnt++;
			}
		}
		if(cnt == N*M) {
			return level-1;
		}else {
			return -1;
		}
	}

}