import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static class Node{
		//kw 크기를 줄인 여부
		int r, c, kw , height, len;
		public Node(int r, int c, int kw, int height, int len) {
			this.r = r;
			this.c = c;
			this.kw = kw;
			this.height = height;
			this.len = len;
		}
	}
	
	static int N, K, maxH, map[][], maxlen;
	static List<Node> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int Tc = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= Tc; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			maxH = Integer.MIN_VALUE;
			list = new ArrayList<>();
			
			//입력 받으면서 제일 높은 값과 제일 높은 곳의 위치 를 list에 저장
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > maxH) {
						maxH = map[i][j];
						list = new ArrayList<>();
						//길이는 자기 자신도 있으니! 1로 시작한다
						list.add(new Node(i, j, 0, map[i][j], 1));
					}
					else if(map[i][j] == maxH) list.add(new Node(i, j, 0, map[i][j], 1));
					else continue;
				}
			}

			maxlen = 0;
			//반복해서 bfs를 돌린다 list의 사이즈 만큼 (list는 최대값 이니깐 )
			for(int i = 0; i < list.size(); i++) {
				Node tmp = list.get(i);
				boolean[][] visited = new boolean[N][N];
				dfs(tmp, visited);
			}
			
			System.out.println("#"+tc + " " + maxlen);
		}
	}

	static int[] dr = {0, 0, -1, 1 };
	static int[] dc = {-1, 1, 0, 0 };
	
	static void dfs(Node tmp, boolean[][]visited){
		
		if(visited[tmp.r][tmp.c]) return;
		maxlen  = Math.max(maxlen, tmp.len);
		if(map[tmp.r][tmp.c] < 0) return;
		
		boolean[][] copyVisted = new boolean[N][N];
		for(int i = 0; i < N; i++) copyVisted[i] = visited[i].clone();
		copyVisted[tmp.r][tmp.c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = tmp.r + dr[i];
			int nc = tmp.c + dc[i];
		
			//범위 밖이면 건너뛰어라
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			if(map[nr][nc] >= tmp.height && tmp.kw == 0) {
				//만약에 K 를 뺏는데도 안될거같으면 그냥 넘어가
				if(map[nr][nc] - K >= tmp.height) continue;
				for(int j = 1; j <= K; j++) {
					//최대한 작은값으로 빼야하야히기 때문에 1부터 증가 
					if(map[nr][nc] - j < tmp.height) {
						dfs(new Node(nr, nc, 1, map[nr][nc]-j, tmp.len+1), copyVisted);
						break;
					}
				}
				
			}
			if(map[nr][nc] >= tmp.height) {
				//단순히 나보다 크기만 하면 넘겨
				continue; 
			}
			//모든 조건에 성립 ( 즉 작다면 )
			//위치와 이전의 사용했는지 정보와 다음 볼 높이
			else {
				if(tmp.kw == 0) {
					dfs(new Node(nr, nc, 0, map[nr][nc], tmp.len+1), copyVisted);				
				}else {
					dfs(new Node(nr, nc, 1, map[nr][nc], tmp.len+1), copyVisted);
				}
			}
		}
		
	}
}