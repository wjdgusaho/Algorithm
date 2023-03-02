import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, W, H, ans = Integer.MAX_VALUE;
	static int[] numbers, inputs;
	static int[][] tile, tmpTile;
	static int [] dr = {-1, 1, 0 , 0}, dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			tile = new int[H][W];
			for(int i = 0; i < H; i++) tile[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			
			numbers = new int[N];
			inputs = new int[W];
			
			for(int i = 0; i < W; i++) inputs[i] = i;
			
			//중복 순열
			perm(0);
			
			System.out.println("#"+t + " " + ans);
			ans = Integer.MAX_VALUE;
		}
	}
	
	private static void perm(int cnt) {
		
		if(cnt == N) {
			boll();
			return;
		}
		for(int i = 0; i < W; i++) {
			numbers[cnt] = inputs[i];
			perm(cnt+1);
		}
	}


	private static void boll() {
		
		//배열 복사
		tmpTile = new int[H][W];
		for(int i = 0; i < H; i++) tmpTile[i] = Arrays.copyOf(tile[i], W);
		
		
		for(int n = 0; n < N; n++) {
			bollOut:
			for(int r = 0; r < H; r++) {
				if(tmpTile[r][numbers[n]] == 0) continue;
				check(r, numbers[n]);
				blockdown();
				break bollOut;
			}
		}
		tileMinCount();
	}


	private static void tileMinCount() {
		
		int cnt = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(tmpTile[i][j] > 0) cnt++;
			}
		}
		ans = Math.min(cnt, ans);
	}



	private static void blockdown() {
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int c = 0; c < W; c++) {
			for(int r = H-1; r >= 0; r--) {
				if(tmpTile[r][c] > 0) que.offer(tmpTile[r][c]); 
			}
			
			for(int r = H-1; r >= 0; r--) {
				if(que.isEmpty()) tmpTile[r][c] = 0;
				else tmpTile[r][c] = que.poll();
			}
		}
	}

	private static void check(int r, int c) {
		
		//num값을 받고
		int num = tmpTile[r][c];
		
		if(num == 0) return;
		
		if(num == 1) {
			tmpTile[r][c] = 0;
			return;
		}
		
		
		tmpTile[r][c] = 0;
		for(int n = 1; n < num; n++) {
			
			for(int i = 0; i < 4; i++) {
				
				int nr = r + dr[i] * n;
				int nc = c + dc[i] * n;
				
				if(nr < 0 || nr >= H || nc < 0 || nc >= W ) continue;
				check(nr, nc);
			}
		}
		return;
	}
}

/*

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW5656 {
	
	static int N, W, H, ans = Integer.MAX_VALUE;
	static int[] numbers, inputs;
	static int[][] tile, tmpTile;
	static int [] dr = {-1, 1, 0 , 0}, dc = {0, 0, -1, 1};
	static boolean[][] visitied;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			tile = new int[H][W];
			for(int i = 0; i < H; i++) tile[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			
			numbers = new int[N];
			inputs = new int[W];
			
			for(int i = 0; i < W; i++) inputs[i] = i;
			
			//중복 순열
			perm(0);
			
			System.out.println("#"+t + " " + ans);
			ans = Integer.MAX_VALUE;
		
		}
		
	}
	
	private static void perm(int cnt) {
		
		if(cnt == N) {
			boll();
			return;
		}
		
		for(int i = 0; i < W; i++) {
			numbers[cnt] = inputs[i];
			perm(cnt+1);
		}
		
	}



	private static void boll() {
		
		//배열 복사
		tmpTile = new int[H][W];
		for(int i = 0; i < H; i++) tmpTile[i] = Arrays.copyOf(tile[i], W);
		
		
		for(int n = 0; n < N; n++) {
			visitied = new boolean[H][W];
			bollOut:
			for(int r = 0; r < H; r++) {
				if(tmpTile[r][numbers[n]] == 0) continue;
				check(r, numbers[n]);
				changes();
				blockdown();
				break bollOut;
			}
			
		}
		tileMinCount();
	}
	



	private static void changes() {
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(visitied[i][j]) tmpTile[i][j] = 0;
			}
		}
		
	}



	private static void tileMinCount() {
		
		int cnt = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(tmpTile[i][j] > 0) cnt++;
			}
		}
		
		ans = Math.min(cnt, ans);
		
	}



	private static void blockdown() {
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int c = 0; c < W; c++) {
			for(int r = H-1; r >= 0; r--) {
				if(tmpTile[r][c] > 0) que.offer(tmpTile[r][c]); 
			}
			
			for(int r = H-1; r >= 0; r--) {
				if(que.isEmpty()) tmpTile[r][c] = 0;
				else tmpTile[r][c] = que.poll();
			}
		}
		
	}



	private static void check(int r, int c) {
		
		//num값을 받고
		int num = tmpTile[r][c];
		
		if(num == 0) return;
		
		if(num == 1) {
			visitied[r][c] = true;
			return;
		}
		
		//if(visitied[r][c]) return;
		
		visitied[r][c] = true;
		for(int n = 1; n < num; n++) {
			
			for(int i = 0; i < 4; i++) {
				
				int nr = r + dr[i] * n;
				int nc = c + dc[i] * n;
				
				if(nr < 0 || nr >= H || nc < 0 || nc >= W ) continue;
				if(visitied[nr][nc]) continue;
				check(nr, nc);
			}
		}
		return;
	}
}

*/