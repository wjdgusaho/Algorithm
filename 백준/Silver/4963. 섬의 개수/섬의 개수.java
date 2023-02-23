import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int W, H, Mcnt;
	static int[][] map;
	static boolean [][] vistied;
	static int[] dr = { 0, 0, -1, 1, 1, -1, -1, 1}, dc = { -1, 1, 0, 0, 1, -1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W == 0 && H == 0) break;
			
			map = new int[H][W];
			vistied = new boolean[H][W];
			for(int h = 0; h < H; h++) {
				map[h] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			for(int h = 0; h < H; h++) for(int w = 0; w < W; w++) {
				if(map[h][w] == 0) {
					vistied[h][w] = true;
				}
				else {
					if(!vistied[h][w]) {
						dfs(h, w);
						Mcnt += 1; 
					}
				}
			}
			System.out.println(Mcnt);
			Mcnt = 0;
			
		}
		
	}

	private static void dfs(int r, int c) {
		
		if(vistied[r][c]) return;
		
		//지금 들어온 내 자리 사용중으로 변경
		vistied[r][c] = true;
		//dr 길이만큼! 반복해봐 8방탐색할게
		for(int i = 0; i < dr.length; i++) {
				
			int nr = r + dr[i];
			int nc = c + dc[i];
				
				//배열 외부로 나간 값이 아니라면 탐색해봐
			if(nr >= 0 && nr < H && nc >= 0 && nc < W) {
					//이전 좌표값과 같다면 넘겨!
					//if(preR == nr && preC == nc) continue;
					//0이면 넘겨!
				if(map[nr][nc] == 0) {
					vistied[nr][nc] = true;
					continue;
				}
					//값이 사용중이야 ? 그럼 넘겨
				if(vistied[nr][nc]) continue;
				dfs(nr, nc);
			}
		}
	}
}