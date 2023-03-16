import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	
	static class Node{
		
		int r, c, v;
		
		public Node(int r, int c, int v) {
			super();
			this.r = r;
			this.c = c;
			this.v = v;
		}
	}
	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		/*
		  터널 모양
		  상  - 1 , 0  / 하  1, 0 / 좌 0 -1 / 우 0 1
		 1    - 상 하 좌 우	 
		 2    - 상 하
		 3    - 좌 우
		 4    - 상 우 
		 5    - 하 우 
		 6    - 하 좌
		 7    - 상 좌
		*/
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1};
		int[][] dir ={
				{0},
				{0, 1, 2, 3},
				{0, 1},
				{2, 3},
				{0, 3},
				{1, 3},
				{1, 2},
				{0, 2}
		};

		//테스트 케이스
		for(int t = 1; t <= T; t++) {
			StringTokenizer  st = new StringTokenizer(br.readLine());
			
			// 세로길이
			int N = Integer.parseInt(st.nextToken());
			// 가로길이
			int M = Integer.parseInt(st.nextToken());
			// 맨홀 뚜껑이 위치한 장소의 세로 위치
			int R = Integer.parseInt(st.nextToken());
			// 맨홀 뚜껑이 위치한 장소의 가로 위치
			int C = Integer.parseInt(st.nextToken());
			// 탈출 후 소요된 시간 
			int L = Integer.parseInt(st.nextToken());
			
			//입력값
			int[][] map = new int[N][M];
			boolean[][] visitid = new boolean[N][M];
			//맨홀 값 입력 받기
			for(int n = 0; n < N; n++) map[n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			//나의 위치는 RC BFS를 하자규!
			Deque<Node> dQue = new LinkedList<>(); 
			
			int Lcnt = 1;
			dQue.offer(new Node(R, C, map[R][C]));
			
			while(!dQue.isEmpty()) {
				
				if(Lcnt > L)break;
				int qsize = dQue.size();
				
				for(int q = 0; q < qsize; q++) {
					
					Node tmp = dQue.pop();
					visitid[tmp.r][tmp.c] = true;
					map[tmp.r][tmp.c] = -1;
					
					//System.out.println(tmp.r +" " + tmp.c+ "    "+tmp.v+ "   "+Lcnt);
					
					for(int i = 0; i < dir[tmp.v].length; i++) {
						
						int nr = tmp.r + dr[dir[tmp.v][i]];
						int nc = tmp.c + dc[dir[tmp.v][i]];
						
						//범위 넘어가면 무시해
						if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
						if(visitid[nr][nc])continue;
						
						//nr값이 나를 바라보고 있는지 체크
						for(int j = 0; j < dir[ map[nr][nc] ].length; j++) {
							int fnr = nr + dr[dir[map[nr][nc]][j]];
							int fnc = nc + dc[dir[map[nr][nc]][j]];
							
							if(fnr < 0 || fnr >= N || fnc < 0 || fnc >= M) continue;
							
							if(fnr == tmp.r && fnc == tmp.c) {
								if(map[nr][nc] == 0)continue;
								dQue.offer(new Node(nr,nc, map[nr][nc]));
								break;
							}
						}
					}
				}
				Lcnt++;
				
			}
			int answerCnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == -1 ) answerCnt++;
					//System.out.print(map[i][j] + " ");
				}
				//System.out.println();
			}
			
			System.out.println("#"+t+" "+answerCnt);
			
		}
	}
}