import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int cnt = 0;
		int time = 0;
		while(cnt < N*M) { 
			//탐색  ( 0 과 2 의 값 을 카운트 값)
			cnt = fourbang();
			//만약에 cnt 값
			
			//만약 cnt 값이 N*M과 같다면 밑에 값을 변경하지 말아주세요! 다 사라지기 전단계이니
			if(cnt == N*M) continue;
			
			//2인 친구들 값 0으로 변경 
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 2) map[i][j] = 0;
				}
			}
			//값이 변경되었으니 시간 증가!
			time++;
		}
		
		//2가 몇개인지 카운트1
		int countTwo = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) countTwo++;
			}
		}
		//시간이 딱 전단계에서 멈춰있으니 1을 더해줘야함! (완전히 사라질때 )
		System.out.println(time+1);
		System.out.println(countTwo);
		
		
	}
	
	static class Node{
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	private static int fourbang() {
		
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };
		
		boolean[][] visited = new boolean[N][M];
		
		int r = 0;
		int c = 0;
		
		Deque<Node> que = new ArrayDeque<Node>();
		//초기값 설정 (가세는 공기라고 제한되어잇음 따라서 0,0 부터 시작해도됨)
		que.offer(new Node(0, 0));
		
		while(!que.isEmpty()) {
			
			//현재 위치
			Node now = que.poll();
			
			//탐색
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				//만약에 다음값이 0이라면 큐에 넣는다!.
				if(map[nr][nc] == 0) {
					que.offer(new Node(nr, nc));
				}else {
					//그게 아니라면 공기와 밀접해있는 1이라고 가정!! 그위치 값 2로변경!
					map[nr][nc] = 2;
				}
				
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 || map[i][j] == 2) cnt++;
			}
		}
		
		return cnt;
	}

}