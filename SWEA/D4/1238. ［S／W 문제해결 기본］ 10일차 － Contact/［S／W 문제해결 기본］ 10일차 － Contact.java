import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {	
    
	static int MAXNUM = 100;
	static int N, start, max = -1;
	static Deque<Integer> que;
	static ArrayList<ArrayList<Integer>> listGraph;
	static ArrayList<int[]> levels;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 0; t < 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
		
			que = new ArrayDeque<>();
			listGraph = new ArrayList<>();
			visited = new boolean[MAXNUM+1];
			levels = new ArrayList<>();
		
			//그래프 초기화
			for(int i = 0; i < MAXNUM+1; i++) listGraph.add(new ArrayList<Integer>());
			
			//입력
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				for(int i = 0; i < 2; i++) {
					int from = Integer.parseInt(st.nextToken());
					int to = Integer.parseInt(st.nextToken());
					
					if(!listGraph.get(from).contains(to)) {
						listGraph.get(from).add(to);
					}		
				}
			}
			
			//큐를 사용?
			que.offer(start);
			
			check();
					
			int level = -1;
			for(int[] levelTmp : levels) level = Math.max(level, levelTmp[1]);
			
			for(int[] levelTmp : levels) {
				if(levelTmp[1] >= level) {
					max = Math.max(levelTmp[0], max);
				}
			}
			
			System.out.println("#" + (t + 1) + " " + max );
			max = -1;
		}
	}

	private static void check() {
		
		int level = 0;
		while(!que.isEmpty()) {
			
			for(int i = 0, end = que.size(); i < end; i++) {
			
				int node = que.poll();
				
				if(visited[node]) continue;
				visited[node] = true;
				
				for(int tmp : listGraph.get(node)) {
					if(visited[tmp]) continue;
					que.offer(tmp);
					levels.add(new int[] {tmp, level});
				}
			}
			level++;
		}
	}
}