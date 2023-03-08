import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		String[][] map = new String[N][M];
		
		for(int i = 0; i < N; i++) map[i] = br.readLine().split("");
		
		String[][] check = {
				{"W", "B", "W", "B", "W", "B", "W", "B"},
				{"B", "W", "B", "W", "B", "W", "B", "W"}
		};
		
		int minChange = Integer.MAX_VALUE;
		//8x8이 나올수 있는 모든 경우를 위한 for문 
		for(int i = 0; i <= N-8; i++) {
			for(int j = 0; j <= M-8; j++) {
			
				//8x8 만들어진후 현재값에서 변경할게 있는지 체크 (2가지 경우 B로 시작한경우 W로 시작한경우)
				for(int t = 0; t < 2; t++) {
					int cnt = 0;  //변경 카운트 
					// 8 x 8 확인해보기
					for(int r = i, rend = r+8; r < rend; r++) {
						int idx = 0;
						for(int c = j, kend = c+8; c < kend; c++) {
							
							if(t == 0) {
								if(r%2==0) {
									if(map[r][c].equals(check[1][idx++])) cnt++;
								}
								else {
									if(map[r][c].equals(check[0][idx++])) cnt++;
								}
							}
							else {
								if(r%2==0) {
									if(map[r][c].equals(check[0][idx++])) cnt++;
								}
								else {
									if(map[r][c].equals(check[1][idx++])) cnt++;
								}
							}	
						}
					}
					minChange = Math.min(cnt, minChange);
				}
			}
		}
		System.out.println(minChange);
	}
}