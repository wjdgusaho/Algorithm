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

	static int N, L, R, map[][];
	static boolean[][] visited;
	static List<int[]> groupList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		// 입력 완룡
		map = new int[N][N];
		for (int i = 0; i < N; i++)
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// 방문 처리
		visited = new boolean[N][N];

		System.out.println(setCnt());

	}

	private static int setCnt() {

		int setNum = 0;
		while (true) {
			
			//System.out.println(setNum+ "--------------------------------------- ");
			
			// 매 세트마다 방문 초기화
			visited = new boolean[N][N];
			
			int groupCnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 방문 했던곳이면 굳이 bfs 돌리지마
					if (visited[i][j]) continue;
					groupList = new ArrayList<>();
					if (bfs(i, j) > 1) groupCnt++;
				}
			}
			// 모든 곳을 다 돌았는데 그룹이 없다면 while을 끝내 버려
			if (groupCnt == 0)
				break;
			setNum++;
		}
		return setNum;
	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	private static int bfs(int r, int c) {

		//System.out.println(r + " " + c);
		// 초기값 세팅
		Deque<int[]> que = new ArrayDeque<>();
		que.offer(new int[] { r, c });
		visited[r][c] = true;
		
		
		while (!que.isEmpty()) {
			
			int[] tmp = que.poll();
			groupList.add(tmp);
			
			for (int i = 0; i < 4; i++) {
				
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];

				//범위를 벗어나면
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				//방문했던곳이라면
				if (visited[nr][nc]) continue;
				//현재 위치랑 바라보는 곳이
				int pCnt = Math.abs(map[nr][nc] - map[tmp[0]][tmp[1]]);
				//L이상 R 이하라면
				if(pCnt >= L && pCnt <= R) {
					que.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		

		//그룹 처리
		if(groupList.size() > 1) { 
			int sum = 0;
			for(int[] group : groupList) {
				//System.out.println(group[0] + " " + group[1] +" " + map[group[0]][group[1]]);
				sum += map[group[0]][group[1]];
			}
			//System.out.println("그룹 더한 값 : " + sum + " 그룹 의 수 " + groupList.size());
			sum = sum/groupList.size(); 
		
			for(int[] group : groupList) {
				map[group[0]][group[1]] = sum;
			}
		}
		/*
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <N; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("==========================");
		*/
		return groupList.size();

	}

}