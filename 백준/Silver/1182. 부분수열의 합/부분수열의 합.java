import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int ans;
	static int N, S, arr[], number[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		
		// N 개의 정수로 이루어진 수열 있을때
		// 크기가 양수인 부분수열중에
		// 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수 ?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		visited = new boolean[N];
		
		ans = 0;
		//부분 순열 : 주어진 수열의 일부 항을 원래 순서대로 나열하여 얻을 수 있는 수열 (연속이지 않아도됨)
		dfs(0);
		
		//아무것도 선택하지 않은 조건을 뺴준다.
		System.out.println(ans);
				
	}
	
	private static void dfs(int cnt) {
		if(cnt == N) {
			int sum = 0;
			int falseCnt = 0;
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					//System.out.print(i + " ");
					sum += arr[i];
				}
				else falseCnt++;
			}
			//System.out.println("==="+sum);
			if(falseCnt == N) return;
			if(sum == S) ans++;
			return;
		}
		visited[cnt] = true;
		dfs(cnt+1);
		visited[cnt] = false;
		dfs(cnt+1);
	}
}