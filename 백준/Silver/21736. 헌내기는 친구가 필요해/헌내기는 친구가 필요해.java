import java.io.*;
import java.util.*;

public class Main {
	
	public static int N, M, sR, sC, cnt;
	public static char[][] map;
	public static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sR = -1;
		sC = -1;
		cnt = 0;
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), "");
			map[i] = st.nextToken().toCharArray();
			if(sR == -1 && sC == -1) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 'I') {
						sR = i;
						sC = j;
					}
				}
			}
		}	
		bfs();
		if(cnt == 0) System.out.println("TT");
		else System.out.println(cnt);
	}
	
	public static int[] dr = {1, -1, 0, 0};
	public static int[] dc = {0,  0, -1, 1};
	public static void bfs() {
		
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {sR, sC});
		
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			for(int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] == 'X') continue;
				if(map[nr][nc] == 'P') cnt++;
				visited[nr][nc] = true;
 				que.offer(new int[] {nr, nc});
			}
		}
	}
}