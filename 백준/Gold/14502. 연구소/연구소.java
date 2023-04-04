import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int ADD_NUM = 3;
	static int N, M, zeroCnt, virusCnt, answer;
	static int[][] map;
	static Point[] number;
	static Point[] input;
	static int[] visited;
	static Point[] virus;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		answer = Integer.MIN_VALUE;
		
		//0의 갯수 카운트
		zeroCnt = 0;
		virusCnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp == 0) zeroCnt++;
				if(tmp == 2) virusCnt++;
			}
		}
				
		number = new Point[3];
		input = new Point[zeroCnt];
		virus = new Point[virusCnt];

		int idx = 0;
		int vidx = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				//0값 일경우에만!
				if(map[i][j] == 0) input[idx++] = new Point(i, j);
				if(map[i][j] == 2) virus[vidx++] = new Point(i, j);
			}
		}
		
		//for(int i = 0; i < zeroCnt; i++) System.out.println(input[i].r + " " + input[i].c); 
		//최대 64 C 3 
		//3개를 선택하는 알고리즘 - 조합
		comb(0, 0);
		
		System.out.println(answer);
	}
	
	private static void comb(int start, int cnt) {
		
		if(cnt == ADD_NUM) {
			/*
			System.out.print(number[0].r + " " + number[0].c +"|");
			System.out.print(number[1].r + " " + number[1].c +"|");
			System.out.print(number[2].r + " " + number[2].c +"|");
			System.out.println();
			*/
			//bfs를 돌린다.
			bfs();
			return;
		}
		
		for(int i = start; i < zeroCnt; i++) {
			number[cnt] = input[i];
			comb(i+1, cnt+1);
		}
	}

	private static void bfs() {
		int[][] copyMap = new int[N][M];
		//map은 변하면 안되므로 copyMap 사용
		for(int i = 0; i < N; i++) copyMap[i] = Arrays.copyOf(map[i], map[i].length);
		
		//추가적인 벽설치
		for(int i = 0; i < ADD_NUM; i++) {
			copyMap[number[i].r][number[i].c] = 1;
		}
		
		/*
		System.out.println("=======");
		for(int i = 0; i < N; i++)System.out.println(Arrays.toString(copyMap[i]));
		
		System.out.println("바이러스 위치 체크");
		for(int i = 0; i < virusCnt; i++) {
			System.out.println(virus[i].r + " " + virus[i].c);
		}
		*/
		
		//2의 기준 탐색 시작
		int[] dr = {0, 0, -1, 1};
		int[] dc = {-1, 1, 0, 0};
		
		Queue<int[]> que = new LinkedList<int[]>();
		
		//초기 que값 설정
		for(int i = 0; i < virusCnt; i++) que.offer(new int[] {virus[i].r , virus[i].c});
		
		while(!que.isEmpty()) {
			
			int[] tmp = que.poll(); 
			copyMap[tmp[0]][tmp[1]] = 2;
			
			for(int i = 0; i < 4; i++) {
				
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				//방문했거나 벽이거나 바이러스이니깐
				if(copyMap[nr][nc] > 0) continue;
				
				que.offer(new int[] {nr , nc});
				
			}
		
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++)for(int j = 0; j < M; j++) if(copyMap[i][j] == 0)cnt++;
		answer = Math.max(cnt, answer);
	}
}