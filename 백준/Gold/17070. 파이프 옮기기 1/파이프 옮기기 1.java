import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
		
	static class Node{
		int r , c;
		int degree;
		public Node(int r, int c, int degree) {
			this.r = r;
			this.c = c;
			this.degree = degree;
		}
	}
	
	//현재 위치가 0도 일때 갈수 있는 곳 
	static int[][] zero = { {0,1,0} , {1,1,45} };
	//현재 위치가 45도 일때 갈수 있는 곳 
	static int[][] fourFive = { {0,1,0} , {1,1,45} , {1,0,90} };
	//현재 위치가 90도 일때 갈수 있는 곳 
	static int[][] nine = { {1,1,45}, {1,0,90} };
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		//입력 값 출력 해보기
		//for(int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));
		
		Deque<Node> que = new ArrayDeque<Node>();
		//초기값 설정
		que.offer(new Node(0, 1, 0));
		int cnt = 0;
		while(!que.isEmpty()) {

			Node now = que.poll();
			int[][] dirc;
			
			if(now.degree == 0) dirc = zero; 
			else if(now.degree == 45) dirc = fourFive;
			else dirc = nine;
			
			//System.out.println(Arrays.deepToString(dirc));
			
			for(int i = 0; i < dirc.length; i++) {
				
				int nr = now.r + dirc[i][0];
				int nc = now.c + dirc[i][1];
				int np = dirc[i][2];
				
				//범위 밖이라면
				if(nr < 0 || nr >= N || nc < 0 || nc >= N)continue;
				//대각선으로 이동할때 양옆에 벽이있다면 
				if(np == 45 && ( map[nr-1][nc] == 1 || map[nr][nc-1] == 1)) continue;
				//이동하려는곳에 벽이있다면
				if(map[nr][nc] == 1)continue;
				
				que.offer(new Node(nr, nc, np));
				if(nr == N-1 && nc == N-1) cnt++;
				
			}
	
		}
		System.out.println(cnt);
	}
}