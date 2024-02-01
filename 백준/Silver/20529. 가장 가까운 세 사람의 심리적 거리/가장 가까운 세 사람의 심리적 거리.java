import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, result;
	public static final int FINED = 3;
	public static char[][] map;
	public static int[] number;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			map = new char[N][4];
			
			
			for(int i = 0; i < N; i++) {
				map[i] = st.nextToken().toCharArray();
			}
			
			number = new int[FINED];
			visited = new boolean[N];
			result = Integer.MAX_VALUE;
			comb(0, 0);
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
	
	
	public static void comb(int start, int cnt) {
		
		if(cnt == FINED) {
			check();
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(visited[i]) continue;
			if(result == 0) return;
			number[cnt] = i;
			visited[i] = true;
			comb(i, cnt+1);
			visited[i] = false;
		}
	}
	
	public static void check() {
		int cnt = 0;
		for(int i = 0; i < FINED-1; i++) {
			for(int j = i+1; j < FINED; j++) {
				for(int k = 0; k < 4; k++) {
					if(map[number[i]][k] == map[number[j]][k])continue;
					cnt++;
				}
			}
		}
		result = Math.min(result, cnt);
	}
}