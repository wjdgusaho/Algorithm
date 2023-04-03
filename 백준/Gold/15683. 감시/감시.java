import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<int[]> list;
	static int answer;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++)
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		list = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				// 첫번째
				if (0 < map[r][c] && map[r][c] < 6)
					list.add(new int[] { r, c });
			}
		}

		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++)
			copyMap[i] = Arrays.copyOf(map[i], map[i].length);
		// 첫번째 리스트 카운트
		dfs(0, copyMap);
		
		System.out.println(answer);
	}

	// list 카운트
	private static void dfs(int lCnt, int[][] copyMap) {

		// 기저조건
		if (list.size() == lCnt) {
			// 칸 검색
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(copyMap[i][j] == 0) cnt++;
				}
			}
			//for(int i = 0; i < N; i++) System.out.println(Arrays.toString(copyMap[i]));
			//System.out.println(cnt);
			//System.out.println("-=======-");
			answer = Math.min(cnt, answer);
			return;
		}

		int[] rc = list.get(lCnt);
		// dfs를 몇번할건지 카운트 ( cctv 번호 )
		int dfCnt = copyMap[rc[0]][rc[1]];

		if (dfCnt == 2) {
			for (int i = 0; i < 2; i++) {
				int[][] copyCopyMap = cctvCheck(dfCnt, i, copyMap, rc);
				dfs(lCnt + 1, copyCopyMap);
			}
		} else if (dfCnt == 5) {
			int[][] copyCopyMap = cctvCheck(dfCnt, 0, copyMap, rc);
			dfs(lCnt + 1, copyCopyMap);
		} else {
			for (int i = 0; i < 4; i++) {
				// cctv num의 drdc가몇번째 값인지 확인하기 위해
				//for(int j = 0; j < N; j++)System.out.println(Arrays.toString(copyMap[j]));
				int[][] copyCopyMap = cctvCheck(dfCnt, i, copyMap, rc);
				dfs(lCnt + 1, copyCopyMap);
			}
		}

	}

	static int[][] arr = { { 0 }, { 1 }, { 2 }, { 3 }, 
			{ 0, 2 }, { 1, 3 }, 
			{ 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 },
			{ 0, 1, 3 }, { 1, 2, 3 }, { 0, 1, 2 }, { 0, 3, 2 }, 
			{ 0, 1, 2, 3 }, 
			};

	private static int[][] cctvCheck(int dfCnt, int i, int[][] copyMap, int[] rc) {
		
		int[][] copyCopyMap = new int[N][M];
		for (int j = 0; j < N; j++)
			copyCopyMap[j] = Arrays.copyOf(copyMap[j], copyMap[j].length);
			
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		int sIdx;
		if (dfCnt == 1)
			sIdx = i;
		else if (dfCnt == 2)
			sIdx = 4 + i;
		else if (dfCnt == 3)
			sIdx = 6 + i;
		else if (dfCnt == 4)
			sIdx = 10 + i;
		else
			sIdx = 14;

		for (int idx = 0; idx < arr[sIdx].length; idx++) {

			int r = rc[0];
			int c = rc[1];

			int nr = r;
			int nc = c;
			while (true) {
				
				//System.out.print("sIdx : "+ sIdx + "  idx : " + idx + "  ");
				//System.out.print(dr[arr[sIdx][idx]]+ " " + dc[arr[sIdx][idx]] +"    ");
				//System.out.println(nr + " " + nc);
				
				nr = nr + dr[arr[sIdx][idx]];
				nc = nc + dc[arr[sIdx][idx]];
				
				// 이렇다는건 이미 범위를 넘었따는것! 그럼 끝내야겠지?
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;
				//벽을 만났으면 끝내야겠지?
				if (copyCopyMap[nr][nc] == 6)break;
				
				// 해당값 -1으로 변경 해라!
				if (copyCopyMap[nr][nc] == 0) copyCopyMap[nr][nc] = -1;
				
			}
		}
		return copyCopyMap;
	}

}