import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	
	static int N, M, zeroCnt, map[][], numbers[], ans;
	static List<Node> list;
	static class Node{
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		
		//원본 맵에 0의개수 
		zeroCnt = 0;
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) zeroCnt++;
				if(map[i][j] == 2) list.add(new Node(i,j));  // 2번의 위치
 			}
		}
		
		ans = Integer.MAX_VALUE;
		
		//fistPrint();
		//comb list.size() C M 개를 선택하는 모든 경우의 수
		numbers = new int[M];
		comb(0, 0);
		
		//결과
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
		
	}
	
	
	private static void comb(int cnt, int start) {
		
		if(cnt == M) {
			bfs();
			return;
		}
		
		for(int i = start; i < list.size(); i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
		
	}
	
	private static void bfs() {
		
		int[] dr = {0, 0, -1, 1};
		int[] dc = {-1, 1, 0, 0};
		
		//bfs 쿠
		Deque<Node> que = new ArrayDeque<>();
		//visited 방문처리
		boolean[][] visited = new boolean[N][N];
		//맵 카피 
		int[][] copyMap = new int[N][N];
		for(int i = 0; i < N; i++) copyMap[i] = map[i].clone();
		//que 초기값 세팅 ( number의 값들이 들어가야하니깐 )
		for(int i = 0; i < M; i++) {
			que.offer(list.get(numbers[i]));
			int listR = list.get(numbers[i]).r;
			int listC = list.get(numbers[i]).c;
			//탐방할때 2가 동시에 붙어 있을때를 대비해서 시작지점은 미리 탐방하지 못하도록 설정 
			copyMap[listR][listC] = -1;
			visited[listR][listC] = true;
		}
		int zero = 0;
		//바이러스 시작된 곳은 0레벨 이니깐
		int level = -1;
		while(!que.isEmpty()) {
			level++;  //레벨 상승
			int size = que.size();
			//같은 레벨 처리하기위한 for문
			//System.out.println(size);
			for(int s = 0; s < size; s++) {
				Node tmp = que.poll();
				//방문처리
				//if(visited[tmp.r][tmp.c]) continue;
				copyMap[tmp.r][tmp.c] = level;
				//탐방
				for(int i = 0; i < 4; i++) {
					int nr = tmp.r + dr[i];
					int nc = tmp.c + dc[i];
					//범위가 벗어난다면
					if(nr < 0 || nr >= N || nc < 0 || nc >= N)continue;
					if(visited[nr][nc]) continue; //방문했다면 스킵
					 //벽또는 바이러스 시작위치라면 스킵해라
					if(copyMap[nr][nc] == 1 || copyMap[nr][nc] == -1) continue;
					//모든게 성립된다면 que에 넣고 방문처리!
					visited[nr][nc] = true;
					que.offer(new Node(nr, nc)); //해당위치가 0이었던게 바뀌었다는 뜼
				}
			}//레벨 종료
			//statePrint(copyMap, level, zero);
		}
		//bfs 종료
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(copyMap[i][j] == 0) zero++;
			}
		}
		if(zero <= M) {
			ans = Math.min(ans, level);
		}
		
	}


	private static void statePrint(int[][] copyMap, int level , int zero) {
		
		System.out.println("현재 선택된 번호 "+ Arrays.toString(numbers));
		System.out.println("----레벨 " + level +"----------");
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(copyMap[i][j] +" ");
			}
			System.out.println();
		}
		
		System.out.println(zero);
		System.out.println("-----------------------------");
	}


	private static void fistPrint() {
		System.out.println("초기 입력값 체크 ");
		System.out.println("N " + N + " M " + M);
		System.out.println("zC "+ zeroCnt + " list.size() " + list.size());
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
		
		System.out.println("-----------------");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + "idx = " + "r : " + list.get(i).r + " c : " + list.get(i).c);
		}
		
		System.out.println("==입력 체크 완료 ==================");
	}
}