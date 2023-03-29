import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int min;
	static int N;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		for(int n = 0; n < N; n++) {
			map[n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			//System.out.println(Arrays.toString(map[n]));
		}
	
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, i, 0, 0);
			visited[i] = false;
		}
		System.out.println(min);
		
	}
	private static void dfs(int start, int now, int sum, int cnt) {
		
		if(cnt == N-1) {
			if(map[now][start] != 0) {
				//System.out.println(sum);
				sum += map[now][start];
				if(sum < min) min = sum;
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i])continue;
			if(map[now][i] == 0)continue;
			visited[i] = true;
			dfs(start, i, sum+map[now][i] , cnt+1);
			visited[i] = false;
		}
	}
}