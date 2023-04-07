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
	
	static class Node{
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, map[][], numbers[], ans, zeroCnt;
	static List<Node> list;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //바이러스 개수
		
		list = new ArrayList<>(); 
		
		map = new int[N][N];
		zeroCnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					zeroCnt++;
					list.add(new Node(i,j));
				}
				if(map[i][j] == 0) zeroCnt++;
			}
		}
		
		//inputPrint();
		ans = Integer.MAX_VALUE;
		
		//list.size() C n 
		numbers = new int[M];
		comb(0, 0);
		
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
		
	}

	

	private static void comb(int cnt, int start) {
		
		if(cnt == M) {
			//System.out.println(Arrays.toString(numbers));
			bfs();
			return;
		}
		
		for(int i = start; i < list.size(); i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
		
	}
	
	private static void bfs() {
		
		int[] dr = {0, 0, -1, 1 };
		int[] dc = {-1, 1, 0, 0 };
		
		Deque<Node> que = new ArrayDeque<>();
		boolean visited[][] = new boolean[N][N];
		
		int[][] copyMap = new int[N][N];
		for(int i = 0; i < N; i++) copyMap[i] = map[i].clone();
		
		//초기값 세팅
		for(int i = 0; i < M; i++) {
			Node tmp = list.get(numbers[i]);
			que.offer(new Node(tmp.r , tmp.c));
			visited[tmp.r][tmp.c] = true;	
			copyMap[tmp.r][tmp.c] = -1;
			
		}
		int cnt = 0;
		int level = -1;
		
		outer:
		while(!que.isEmpty()) {
			
			level++;
			int size = que.size();
			if(zeroCnt == (cnt+list.size())) break outer;
			for(int s = 0; s < size; s++) {
				Node tmp = que.poll();
				copyMap[tmp.r][tmp.c] = level;
				
				for(int i = 0; i < 4; i++) {
					int nr = tmp.r + dr[i];
					int nc = tmp.c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if(visited[nr][nc]) continue;
					//벽이거나 초기에 활성화 시킨 바이러스면 가지마 (바이러스 옆 바이러스 있을수 있으니)
					if(copyMap[nr][nc] == 1 || copyMap[nr][nc] == -1) continue;
					if(copyMap[nr][nc] == 2) {
						//System.out.println("내부 "+ (cnt + list.size()));
						
						//que.offerFirst(new Node(nr, nc));
						//visited[nr][nc] = true;
						//s--;
					}
					//비활성 바이러스면 활성화 시켜라 ? 근데 굳이 필요한가 ?
					que.offer(new Node(nr, nc));
					if(!visited[nr][nc] && copyMap[nr][nc] != 2)cnt++;
					visited[nr][nc] = true;	
				}
			}//level 종료
			//statePrint(level, copyMap);
		}//bfs 종료
		
		//System.out.println(cnt+M);
	
		if((cnt+list.size()) == zeroCnt) ans = Math.min(ans, level);
		
	}

	private static void statePrint(int level, int[][] copyMap) {
		
		System.out.println("====== "+level+" ======");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(copyMap[i][j] +" ");
			}
			System.out.println();
		}
	
		System.out.println("-----------------------");
		
	}



	private static void inputPrint() {
		
		System.out.println("====== 입력값 확인 ======");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----- 바이러스 위치 -----");
		for(Node tmp : list) {
			System.out.println(tmp.r + " " + tmp.c);
		}
		System.out.println("zero : " + zeroCnt);
		System.out.println("====== 입력값 확인 끝 ======");
	}

}