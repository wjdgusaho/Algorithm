import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				map[r][c] = 1;
			}
			
			int cnt = 0;
			for(int i = 0; i <N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
						
//						System.out.println("=====================");
//						for(int k = 0; k < N; k++) {
//							for(int y = 0; y < M; y++){
//								
//								System.out.print(map[k][y] + " ");
//								
//								}
//							System.out.println();
//							}
					}
				}
			}
			
			System.out.println(cnt);
			
			
		}
		
	}
	
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void dfs(int r, int c) {
		map[r][c] = -1;
		
		for(int i = 0; i < 4; i++) {
			
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M ) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc] == 0)continue;
			visited[nr][nc] = true;
			dfs(nr, nc);
			
		}
		
	}
	
}