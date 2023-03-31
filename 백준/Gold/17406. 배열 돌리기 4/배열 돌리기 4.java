import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main {
	
	// 순열을 구해서 그 순서를가지고 배열을 돌린다. 돌린후의 값을 가지고 최소값을 찾아 저장
	//K의 경우의 수!
	//순서를 선택할수 있는 경우의 수
	// 1 2 3 4 5 6
	// 1 3 2 4 5 6
	// 순열 ? 6 C 6 => 
		
	//배열을 돌려야한다! (배열 돌리는 함수) <- 배열이 변하면 안되기떄문에 copy 배열해야한다.
	
	static int answer;
	static int N, M, K;
	static int[][] map;
	static List<int[]> list;
	//comb를 위한 배열
	static int[] numbers;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		answer = Integer.MAX_VALUE;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		list = new ArrayList<int[]>();
		for(int i = 0; i < K; i++) list.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
		
		//순열을 위한! 
		visited = new boolean[K];
		numbers = new int[K]; 
		perm(0);
		
		System.out.println(answer);
		
	}
	
	private static void perm(int cnt) {
		if(cnt == K) {
			//여길 들어왔다는것은 현재 순열을 뽑았다 (즉 현재 값을 가지고 ! 배열 돌리기를 진행하면됨 )
			//System.out.println(Arrays.toString(numbers));
			Controller();
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(visited[i]) continue;
			numbers[cnt] = i;
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;
		}
	}

	//배열 돌리기
	private static void Controller() {
		
		//배열 복사
		int[][] copyMap = new int[N][M];
		for(int i = 0; i < N; i++) copyMap[i] = Arrays.copyOf(map[i], map[i].length);
		
		//리스트 사이즈 만큼 !
		for(int l = 0; l < list.size(); l++) {
			
			//배열 의 범위가 
			// (r-s , c-s)  ~ ( r+s, r+s )
			// 시계방향으로 회전
			int r = list.get(numbers[l])[0];
			int c = list.get(numbers[l])[1];
			int s = list.get(numbers[l])[2];
			//System.out.println("r "+ r + " c " + c + " s "+ s);
			
			//제한 
			// 1 ≤ r-s < r < r+s ≤ N
			// 1 ≤ c-s < c < c+s ≤ M
			
			// s만큼 회전 (결국엔 가운데 값은 무조건 1개밖에 올수없기때문에 제외)
			for(int i = 0; i < s; i++) {
				if(r-(s-i) == r+(s-i) && c-(s-i) == c+(s-i))continue;
				
				int[] start = {r-(s-i)-1, c-(s-i)-1};
				int[] end = {r+(s-i)-1, c+(s-i)-1};
				
				//System.out.println("start "+ Arrays.toString(start));
				//System.out.println("end  "+Arrays.toString(end));
				arrSwing(copyMap, start, end);
			}
			
		}	
		
		//copyMap 행별로 값 구하기!
		int sumValues[] = new int[N];
		for(int i = 0; i  < N; i++) {
			int sum = 0;
			for(int j = 0; j < M; j++) {
				sum += copyMap[i][j];
			}
			sumValues[i] = sum;
		}
		
		//for(int i = 0; i < N; i++)System.out.println(Arrays.toString(copyMap[i]));
		
		//행들의 합 중 최적값 구하기
		int arrMin = Integer.MAX_VALUE;
		for(int i : sumValues) arrMin = Math.min(arrMin, i);
		
		//전체에서 최저인지 판단!
		answer = Math.min(answer, arrMin);
	}

	private static void arrSwing(int[][] copyMap, int[] start, int[] end) {
		
		//시계방향응로 탐색 오 아 왼 위
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		int[] checkR = {start[0], end[0], end[0] , start[0] };
		int[] checkC = {end[1], end[1], start[1], start[1]}; 
		
		//System.out.println(Arrays.toString(checkR));
		//System.out.println(Arrays.toString(checkC));
				
		int cnt = 0;
		int r = start[0];
		int c = start[1];
		int tmp1, tmp2;
		
		//맨 처음  이동할 값 
		tmp1 = copyMap[r][c];
		
		while(cnt < 4) {
			
			//이동
			r += dr[cnt];
			c += dc[cnt];
			
			//이동한 곳의 값을 tmp2에 저장 			
			tmp2 = copyMap[r][c];
			//이동한 곳의 값을 변경 
			copyMap[r][c] = tmp1;
			tmp1 = tmp2;
			

			//System.out.println(r + " " + c + " " + cnt);
			//현재위치기 checkR 과 checkC 위치라면 ! cnt를 ++ 방향을 전환!
			if(r == checkR[cnt] && c == checkC[cnt]) cnt++;
			
			
					
		}
	}
		
}

/*
5 6 3
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1
2 2 2
 * 
 * 
 */