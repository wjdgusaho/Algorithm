import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	

	// 첫번째 줄 건물개수 N / 도로개수 M
	// 두번째줄부터(도로 개수만큼)  건물1 과 건물2 <- 두개가 연결되어있다. 1시간 거리 양방향 
	// 같은 도록 중복 X / 어떤 두 건물을 잡아도 도로를 따라서 오고 가는 방법이 존재!
	
	// 키친 도시에서 2개의 건물을 골라 치킨집 
	// 모든 건물에서 가장 가까운 치킨집까지 왕복하는 최단 시간의 총합 -> 최소화
	
	static int N, M, ans, ansA, ansB;
	static int[] number;
	static boolean[] check;
	static List<Integer>[] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//인접 리스트
		arr = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
		    arr[i] = new ArrayList<Integer>();
		}
		
		//인접 리스트 입력
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
				
			arr[A].add(B);
			arr[B].add(A);
		
			//System.out.println(Arrays.toString(arr));
		}
		
		ans = Integer.MAX_VALUE;
		number = new int[2];
		check = new boolean[M];
		comb(0, 1);
		
		System.out.println(ansA + " " + ansB + " " + ans);
		
		//출력
		/*
		for(int n = 1; n <= N; n++) {
			
			System.out.print(n + " : ");
			for(int i = 0; i < arr[n].size(); i++) {
				System.out.print(arr[n].get(i) + " ");
			}
			System.out.println();
		}
		*/
		
	}

	private static void comb(int cnt, int start) {
		
		if(cnt == 2) {
			//System.out.println(Arrays.toString(number));
			int dis = distance();
			if(ans > dis) {
				ans = dis;
				ansA = number[0];
				ansB = number[1];
			}
			
			//System.out.println(number[0] + " " + number[1] + " " + dis);
			
			return;
		}
		
		for(int i = start; i <= N; i++) {
			number[cnt] = i;
			comb(cnt+1, i+1);
		}
	}

	//선택된 것으로부터의 거리
	private static int distance() {
		//int dis[] = new int[N+1];
		
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			if(i == number[0] || i == number[1])continue;
			sum += find(i);
		}
		
		//System.out.println(Arrays.toString(dis));
		//왕복이니깐
		return sum * 2;
		
	}
	
	//시작과 끝점의 거리찾기(둘중 제일 짧은값)
	private static int find(int end) {
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i< 2; i++) {
			int start = number[i];
			if(end == start)continue;
			min = Math.min(bfs(start, end), min);	
		}
		return min;
	
	}
	

	private static int bfs(int start, int end) {
		
		//System.out.println("start " + start + " end " + end);
		
		boolean[] visited = new boolean[N+1];
		Queue<Integer> que = new ArrayDeque<Integer>();
		que.offer(start);
		visited[start] = true;
		int level = 0;
		
		
		queEnd:
		while(!que.isEmpty()) {
			int size = que.size();
			level++;
			
			for(int i = 0; i < size; i++) {
				int tmp = que.poll();
				if(tmp == end) break queEnd;
				if(visited[tmp])continue;
				visited[tmp] = true;
				for(int j = 0; j < arr[tmp].size(); j++) {
					que.offer(arr[tmp].get(i));
				}
			}
		}
		
		return level;
	
	}

}