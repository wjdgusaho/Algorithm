import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, T, swordTime, findTime, ans;
	static int[][] map;
	static int[] sword;
	static boolean swordFlag;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		sword = new int[2];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[n][m] = tmp;
				if(tmp == 2) {
					sword[0] = n;
					sword[1] = m;
				}
			}
		}
		ans = Integer.MAX_VALUE;
		swordTime = -1;
		findTime = -1;
		bfsCheck();
		//System.out.println(ans);
		if(ans <= T)System.out.println(ans);
		else System.out.println("Fail");
		
	}
	
	private static void bfsCheck() {
		//공주님 찾기 (찾으면서! 칼을 찾을수 잇는가 ? )
		swordFlag = false;
		bfs();
		//칼을 찾았더라면 그위치부터 bfs2()
		if(swordTime != -1) {
			swordFlag = true;
			//System.out.println("swordfirst : " + swordTime);
			bfs2(sword[0], sword[1]);
		}
				
		//둘다 찾은경우
		if(swordFlag && findTime != -1) ans = Math.min(ans , Math.min(swordTime, findTime));
		//시간만인경우
		else if(findTime != -1 && !swordFlag) ans = findTime;
		//소드만 받은경우
		else if(swordFlag && findTime == -1) ans = swordTime;
		//그렇지 못한경우
	}

	private static void bfs2(int a, int b) {
		
		Queue<int[]> que = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N][M];
		que.offer(new int[] {a, b});
		visited[a][b] = true;
		int level = 0;
	
		queEnd:
		while(!que.isEmpty()) {
			
			int size = que.size();
			
			for(int i = 0; i < size; i++) {
				
				int[] tmp = que.poll();
				int r = tmp[0];
				int c = tmp[1];
				
				if(r == N-1 && c == M-1) {
					swordTime += level;
					break queEnd;
				}
		
				for(int j = 0; j < 4; j++) {
				
					int nr = r + dr[j];
					int nc = c + dc[j];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 1 && !swordFlag) continue;
					visited[nr][nc] = true;
					que.offer(new int[] {nr, nc});

				}	
			}	
			level++;
			
		}//while문 끝
		
	}

	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	private static void bfs() {
		Queue<int[]> que = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N][M];
		que.offer(new int[] {0, 0});
		visited[0][0] = true;
		int level = 0;
	
		while(!que.isEmpty()) {
			
			int size = que.size();
			
			for(int i = 0; i < size; i++) {
				
				int[] tmp = que.poll();
				int r = tmp[0];
				int c = tmp[1];
				
				if(r == N-1 && c == M-1) findTime = level;
				if(map[r][c] == 2) swordTime = level;
				
				for(int j = 0; j < 4; j++) {
				
					int nr = r + dr[j];
					int nc = c + dc[j];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 1 && !swordFlag) continue;
					visited[nr][nc] = true;
					que.offer(new int[] {nr, nc});

				}	
			}	
			level++;
			
		}//while문 끝
				
	}

}