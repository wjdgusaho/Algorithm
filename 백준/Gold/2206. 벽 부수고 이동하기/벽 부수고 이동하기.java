import java.io.*;
import java.util.*;

public class Main {

	public static int N, M;
	public static int[][] map;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		int b = bfs(0, 0);
		System.out.println(b);
	}
	
	public static class Data {
		int r, c;
		boolean bAble;
		
		public Data(int r, int c, boolean bAble) {
			this.r = r;
			this.c = c;
			this.bAble = bAble;
		}
	}
	
	public static boolean[][][] visited;
	public static int[] dr = {0, 0, -1, 1};
	public static int[] dc = {-1, 1, 0, 0};
	public static int bfs(int sR, int sC) {
		
		visited = new boolean[2][N][M];		
		Queue<Data> que = new ArrayDeque<Data>();
		que.offer(new Data(sR, sC, true));
		visited[0][sR][sC] = true;
		visited[1][sR][sC] = true;
		
		int level = 1;
		boolean endPoint = false;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int s = 0; s < size; s++) {
				Data tmp = (Data) que.poll();
				//System.out.println(tmp.r + " " + tmp.c + " | "+ tmp.bAble + " | " + level);
				if(tmp.r == N-1 && tmp.c == M-1) {
					return level;
				}
				for(int i = 0; i < 4; i++) {	
					int nr = tmp.r + dr[i];
					int nc = tmp.c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if(tmp.bAble) {
						if(visited[0][nr][nc])continue;	
						if(map[nr][nc] == 1) {
							que.offer(new Data(nr, nc, false));
							visited[1][nr][nc] = true;
						}
						else {
							que.offer(new Data(nr, nc, tmp.bAble));
							visited[0][nr][nc] = true;
						}
					}
					else {
						if(visited[1][nr][nc])continue;
						if(map[nr][nc] == 1)continue;
						que.offer(new Data(nr, nc, tmp.bAble));
						visited[1][nr][nc] = true;
					}
				}
			}
			level++;			
		}	
		return -1;
	}
}