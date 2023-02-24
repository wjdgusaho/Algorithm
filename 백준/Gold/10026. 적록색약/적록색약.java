import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	//인접한지 확인하고 연결되어있나 확인!
	//섬문제와 비슷한듯
	// 일반사람
	// 카운딩
	// 색약
	// 카운팅
	// 출력 (이순일듯)
	
	static char[][] map;
	static boolean[][] selected;
	static int N, cnt;
	static int[] dr, dc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		//방문 처리를 위한 배열 (정상)
		selected = new boolean[N][N];
		
		//4방 탐색
		dr = new int[] {-1, 1, 0, 0};
		dc = new int[] {0, 0, -1, 1};
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(selected[r][c]) continue;
				if(!selected[r][c]) {
					dfs(r, c);	
					cnt++;
				}
			}
		}
		System.out.print(cnt +" ");
		cnt = 0;
		
		//방문 처리 초기화! (비정상)
		selected = new boolean[N][N];
		//적록 색약을위한 맵 초기화
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 'G') {
					map[r][c] = 'R';
				}
			}
		}
		
		//탐색
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(selected[r][c]) continue;
				if(!selected[r][c]) {
					dfs(r, c);	
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	
		
		
		//System.out.println(Arrays.deepToString(map));
	}
	
	private static void dfs(int r, int c) {
		//방문 체크!
		selected[r][c] = true;
	
		//4방탐색
		for(int i = 0; i < 4; i++) {
			
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			//범위 설정
			if(nr < 0 || nr >= N || nc < 0 || nc >= N ) continue;
			
			//만약에 방문했던 위치면
			if(selected[nr][nc]) continue;
			
			//방문을 하지 않았는데 같은 문자라면?
			if(map[nr][nc] == map[r][c]) dfs(nr, nc);
			
		}
		return;
	}
}