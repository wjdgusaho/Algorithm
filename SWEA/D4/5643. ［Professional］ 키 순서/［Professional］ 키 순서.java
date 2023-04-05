import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, adj[][], cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N+1][N+1];
			
			StringTokenizer st = null;
			int a, b;
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine()," ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1; //유향
			}
			
			int ans = 0;
			for(int k = 1; k <= N; k++) {
				//첫번째 정점부터 자신보다 큰 정점을 탐색해가라
				cnt = 0;
				gtDFS(k, new boolean[N+1]);
				ltDFS(k, new boolean[N+1]);
				//자신의 키순서가 알수 있는 친구가된다.
				if(cnt == N-1 ) ans++;
			}
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	
	//자신보다 큰애를 따라다니는 DFS
	//cur : 탐색 정점
	static void gtDFS(int cur, boolean[] visited) {
		//cur 정점 기준으로 자신보다 """큰""" 정점 탐색 (자신의 인접행렬을 봐야한다)
		//cnt++ 이 위치에 있다면 자기자신도 카운티 되기떄문에 X~!
		visited[cur] = true;
		for(int i = 1; i <= N; i++) {
			//나랑 인접한데 방문하지 않았다면!!
			if(adj[cur][i] == 1 && !visited[i]) {
				cnt++;
				gtDFS(i, visited);
			}
		}
	}
	
	static void ltDFS(int cur, boolean[] visited) {
		//cur 정점 기준으로 자신보다 """작은""" 정점 탐색 (자신의 인접행렬을 봐야한다)
		//cnt++ 이 위치에 있다면 자기자신도 카운티 되기떄문에 X~!
		visited[cur] = true;
		for(int i = 1; i <= N; i++) {
			//나랑 인접한데 방문하지 않았다면!!
			if(adj[i][cur] == 1 && !visited[i]) {
				cnt++;
				ltDFS(i, visited);
			}
		}
	}
	
	
}