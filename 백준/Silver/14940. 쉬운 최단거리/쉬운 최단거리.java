import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, M;
	public static int[][] map;
	public static int[] start;
	public static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		start = new int[2];
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		bfs();
		check();
		out();
	}
	
	public static int[] dr = {-1, 1, 0 , 0};
	public static int[] dc = {0, 0, -1, 1};
	public static void bfs() {
		
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {start[0], start[1]});
		visited[start[0]][start[1]] = true;
		int level = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i = 0 ; i < size; i++) {
				//방문한 레벨 저장
				int[] tmp = que.poll();
				map[tmp[0]][tmp[1]] = level;
			
				for(int j = 0; j < 4; j++) {
					int nr = dr[j] + tmp[0];
					int nc = dc[j] + tmp[1];
					//제한 조건
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 0) continue;
					visited[nr][nc] = true;
					que.offer(new int[] {nr, nc});
				}
			}
			level++;
		}
	}
	
	public static void out() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void check() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					map[i][j] = -1;
				}
			}
		}
	}
}