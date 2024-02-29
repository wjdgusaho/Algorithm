import java.io.*;
import java.util.*;

public class Main {

	public static int N, M;
	public static int[] arr;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[100+1];
		visited = new boolean[100+1];
		
		for(int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = b;
		}
		
		bfs();
	}
	
	public static void bfs() {
		
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(1);
		visited[1] = true;
		int level = 0;
		whileEnd:
		while(!que.isEmpty()) {
			int size = que.size();
			for(int s = 0; s < size; s++) {
				int num = que.poll();
				if(num == 100) {
					break whileEnd;
				}
			
				for(int i = 1; i <= 6; i++) {
					int nextNode = num+i;
					if(nextNode < 1 || nextNode > 100)continue;
					if(visited[nextNode])continue;
					if(arr[nextNode] != 0) {
						//사다리나 뱀이 있다는거
						if(visited[arr[nextNode]]) continue;
						else {
							que.offer(arr[nextNode]);
							visited[arr[nextNode]] = true;
						}
					}
					else {
						que.offer(nextNode);
						visited[nextNode] = true;
					}
				}
			}
			level++;
		}
		System.out.println(level);
		
	}
}