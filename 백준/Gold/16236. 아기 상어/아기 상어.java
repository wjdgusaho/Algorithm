import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;


public class Main {
	
	static int N;
	static int sR, sC, sW;
	static int[][] map;
	static int eatCnt;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		//상어 값 설정
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 9) {
					sR = i;
					sC = j;
					sW = 2;
				}
			}
		}
		
		eatCnt = 0;
		int answer = 0;
		while(true) {			
			int time = bfs();
			if(time == 0) break;
			//시간이 나왔다는것은 먹엇따믄것
			if(eatCnt == sW) {
				eatCnt = 0;
				sW+=1;
			}
			answer += time;	
		}
		System.out.println(answer);
	}
	
	static int bfs(){
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		boolean[][] visitied = new boolean[N][N];
		Deque<int[]> que = new ArrayDeque<int[]>();
		que.offer(new int[] {sR, sC, sW});
		visitied[sR][sC] = true;
		
		int level = 1;
		int[] point = null;
		
		while(!que.isEmpty()) {
			
			int qSize = que.size();
			//System.out.println("level : " +  level + "=======");
			for(int s = 0; s < qSize; s++) {
				
				int[] now = que.poll();
				int r = now[0];
				int c = now[1];
				
				//탐색위치 
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					//범위를 벗어났다면 
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					//이미 방분했으면 넘어가
					if(visitied[nr][nc]) continue;
					visitied[nr][nc] = true;

					if(map[nr][nc] > sW) continue;
						
					//해당 위치가 
					if(map[nr][nc] > 0 && map[nr][nc] < sW) {
						
						if(point == null) point = new int[] {nr, nc, level};
						else {
							if (point[0] > nr){
								point = new int[] {nr, nc, level};
							}else if (point[0] == nr) {
								if(point[1] > nc) {
									point = new int[] {nr, nc, level};
								}else continue;
							}else continue;
						}
					}
					que.offer(new int[] {nr, nc, map[nr][nc]});
				}
			}
			if(point != null) break;
			level++;
		}

		if(point == null) return 0;
		map[sR][sC] = 0;
		sR = point[0];
		sC = point[1];
		map[sR][sC] = 9;
		eatCnt++;
		
		//System.out.println("-----------------------------");
		//for(int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));
		return point[2];
	}
}