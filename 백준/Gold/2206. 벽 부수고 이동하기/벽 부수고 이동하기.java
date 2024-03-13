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
		int a = bfs(N-1, M-1, false);
		int b = bfs(0, 0, true);
		System.out.println(Math.min(a, b) == -1 ? Math.max(a, b) : Math.min(a, b));
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
	
	public static boolean[][] visited;
	public static int[] dr = {0, 0, -1, 1};
	public static int[] dc = {-1, 1, 0, 0};
	public static int bfs(int sR, int sC, boolean first) {
		
		visited = new boolean[N][M];		
		Queue<Data> que = new ArrayDeque<Data>();
		que.offer(new Data(sR, sC, true));
		visited[sR][sC] = true;
		
		int level = 1;
		boolean endPoint = false;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int s = 0; s < size; s++) {
				Data tmp = (Data) que.poll();
				//System.out.println(tmp.r + " " + tmp.c + " | "+ tmp.bAble + " | " + level);
				if(tmp.r == 0 && tmp.c == 0 && !first) {
					return level;
				}
				if(tmp.r == N-1 && tmp.c == M-1 && first) {
					return level;
				}
				for(int i = 0; i < 4; i++) {	
					int nr = tmp.r + dr[i];
					int nc = tmp.c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if(visited[nr][nc])continue;
					if(map[nr][nc] == 1 && tmp.bAble) {
						visited[nr][nc] = true;				
						que.offer(new Data(nr, nc, false));
					}
					else if(map[nr][nc] == 0) {
						visited[nr][nc] = true;
						que.offer(new Data(nr, nc, tmp.bAble));
					}
					else continue;
				}
			}
			level++;			
		}	
		return -1;
	}
}