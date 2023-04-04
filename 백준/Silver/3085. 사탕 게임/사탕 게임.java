import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		for(int i = 0; i < N; i++)map[i] = br.readLine().toCharArray();
		//for(int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));
		
		int ans = 0;
		char[][] copyMap = new char[N][N];
		//행 위치 바꾸기
		for(int i = 0; i < N; i++) {
			 
			for(int j = 0; j < N-1; j++) {
				//행  위치 변경
				for(int k = 0; k < N; k++) copyMap[k] = map[k].clone(); 
				char tmp = copyMap[i][j];
				copyMap[i][j] = copyMap[i][j+1];
				copyMap[i][j+1] = tmp;
				
				//System.out.println("행 병경 ");
				//for(int k = 0; k < N; k++) System.out.println(Arrays.toString(copyMap[k])); 
				
				int eat = check(copyMap);
				ans = Math.max(eat, ans);
				
				
				//열 위치 변경 
				for(int k = 0; k < N; k++) copyMap[k] = map[k].clone(); 
				tmp = copyMap[j][i];
				copyMap[j][i] = copyMap[j+1][i];
				copyMap[j+1][i] = tmp;
			
				//System.out.println("열 변경");
				//for(int k = 0; k < N; k++) System.out.println(Arrays.toString(copyMap[k]));
				
				
				eat = check(copyMap);
				ans = Math.max(eat, ans);
				
				//System.out.println(ans);
				
				//System.out.println("===============================");
			
			}
		}
		System.out.println(ans);
	}

	private static int check(char[][] copyMap) {
		
		int maxCnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				//해당 i j 의 시작으로 오른쪽 탐색했을때 연속인가 ?
				int cnt = 1;
				//Queue<Integer> que = new ArrayDeque<>();
				int nc = j;
				while(true) {
					
					nc += 1;
					//끝에 도달하면 끝내
					if(nc < 0 || nc >= N) break;
					if(copyMap[i][nc] != copyMap[i][j]) break;
					//그럼 배열 범위 안이면서 값도 같아 ? 그럼 cnt++해
					cnt+=1;
				}
				maxCnt = Math.max(cnt, maxCnt);
				
				cnt = 1;
				int nr = j;
				while(true) {
					nr += 1;
					if(nr < 0 || nr >= N) break;
					if(copyMap[nr][i] != copyMap[j][i]) break;
					cnt+=1;
				}
				maxCnt = Math.max(cnt, maxCnt);
			}
		}
		return maxCnt;
		
	}
}