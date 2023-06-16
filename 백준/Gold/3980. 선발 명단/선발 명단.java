import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	// 11명의 선수 각각 포지션에서 능력 0 ~ 100 수치화 / 0은 적합X
	// 선수의 포지션을 정하는 프로그램
	// 각선수가 능력치가 0인 포지션은 배치 X
	// 모든 포지션에 선수를 배치
	
	// 능력치의 합이 최댓값을 출력
	
	// 11 X 11 
	// dfs -> 가지치기
	static int T, ans;
	static int[][] map;
	static int[] member;
	static boolean[] visited;
	static int PLAYER = 11;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			
			map = new int[PLAYER][PLAYER];
			
			for(int i = 0; i < PLAYER; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			ans = Integer.MIN_VALUE;
			member = new int[PLAYER];
			visited = new boolean[PLAYER];
			dfs(0);
			System.out.println(ans);
			
		}
	}
	
	
	private static void dfs(int cnt) {
		if(cnt == PLAYER) {
			int sum = 0;
			for(int i = 0; i < PLAYER; i++) {
				sum += member[i];
			}	
			ans = Math.max(sum, ans);
			return;
		}
		
		for(int i = 0; i < PLAYER; i++) {
			if(map[cnt][i] == 0) continue;
			if(visited[i]) continue;
			visited[i] = true;
			member[cnt] = map[cnt][i];
			dfs(cnt+1);
			visited[i] = false;
		}
	}
}