import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	static int N, sum;
	static int[][] arr, map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N*N][5];
		map = new int[N][N];
		
		
		for(int i = 0; i < N*N; i++) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		start();
		
		//for(int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));
		
		//값을 찾기위한 정렬
		Arrays.sort(arr, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		sum = 0;
		check();
		System.out.println(sum);
		
		//for(int i = 0; i < N*N; i++) System.out.println(Arrays.toString(arr[i]));
	}
	private static void check() {
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				int cnt = 0;
				for(int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					
					for(int j = 1; j <= 4; j++) {
						if(arr[map[r][c]-1][j] == map[nr][nc])cnt++;
					}
				}
				if(cnt == 1) sum += 1;
				else if(cnt == 2) sum += 10;
				else if(cnt == 3) sum += 100;
				else if(cnt == 4) sum += 1000;
			}
		}
		
	}
	static class Node implements Comparable<Node> {
		int r, c, w;

		public Node(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			if(o.w - this.w == 0) {
				if(this.r - o.r == 0) return this.c - o.c;
				else return this.r - o.r;
			}
			else {
				return o.w - this.w;
			}
		}
		
	}
	static int[] dr = { 0, 0, -1 , 1};
	static int[] dc = { -1, 1, 0, 0 };
	private static void start() {
	
		for(int i = 0; i < N*N; i++) {
			
			List<Node> tmpList = new ArrayList<>();
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					//이미 값이 있으니깐 가중치 주지마
					if(map[r][c] > 0) continue;
					//가중치 따지기
					int tmpW = 0;
					for(int j = 0; j < 4; j++) {
						int nr = r + dr[j];
						int nc = c + dc[j];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						
						if(map[nr][nc] == 0) tmpW += 1;
						else {
							for(int k = 1; k <= 4; k++) {
								if(arr[i][k] == map[nr][nc]) {
									tmpW +=5; 
								}
							}
						}	
					}
					tmpList.add(new Node(r, c, tmpW));
				}
			}
			
			Collections.sort(tmpList);
	
			Node tmp = tmpList.get(0);
			map[tmp.r][tmp.c] = arr[i][0];
			
		}
		
	}
}