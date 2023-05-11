import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	static int R, C, N;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		//map 입력
		map = new char[R][C];
		for(int i = 0; i< R; i++) map[i] = br.readLine().toCharArray();	
		
		bfs();
		//결과 출력
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static class Node{
		int r, c, time;

		public Node(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0 ,0};
 	private static void bfs() {
		//초기값 세팅
		Deque<Node> que = new ArrayDeque<>();
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 'O') que.offer(new Node(r,c,1));
			}
		}
		
		int level = 0;
		while(true) {
			level++;

			//사이즈 체크 
			int size = que.size();
		
			for(int i = 0; i < size; i++) {
				Node tmp = que.poll();
				//System.out.println(tmp.r + " " + tmp.c +" " + tmp.time);
				//3초인지 확인
				if(tmp.time == 3) {
					//폭탄 터리기
					boom(tmp);
				}
				else {
					if(map[tmp.r][tmp.c] == '.') continue;
					else {
						tmp.time+=1;
						que.offer(tmp);
					}
				}
			}
			
			//빈칸 값 변경
			if(level%2 == 0) {
				for(int r = 0; r < R; r++) {
					for(int c = 0; c < C; c++) {
						if(map[r][c] == '.') {
							map[r][c] = 'O';
							que.offer(new Node(r,c,1));
						}
					}
				}
			}
			
			if(level == N) break;
		}
		
	}
 	
	private static void boom(Node tmp) {
		//자기자신 폭파
		map[tmp.r][tmp.c] = '.';
		//주변폭파
		for(int i = 0; i < 4; i++) {
			int nr = tmp.r + dr[i];
			int nc = tmp.c + dc[i];
			
			//범위 밖
			if(nr < 0 || nr >= R || nc < 0 || nc >= C)continue;
			//그게 아니라면 폭파시켜라 
			map[nr][nc] = '.';
			
		}
		
	}

}