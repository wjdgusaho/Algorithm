import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int R = 100;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 0; t < 10; t++) {
			
			int num = Integer.parseInt(br.readLine());
			
			String[][] strArr = new String[R][];
			for(int i = 0; i < R; i++) {
				strArr[i] = br.readLine().split(" ");
			}
			
			//맨끝부터 2 위치 찾기
			int r = R-1;
			int c = 0;
			for(int i = 0; i < R; i++) {
				if(strArr[R-1][i].equals("2")) {
					c = i;
					break;
				};	
			}
			//2방 탐색
			//      오른쪽,  왼졲 
			int[] dr =  {0, 0};
			int[] dc = {1, -1};
			
			int preC = c;
			
			while(r >= 0) {	
				//바뀌었는지 확인을 위해 값을넣어줌 
				int changC = c;
				//탐색을 위한 for문
				for(int i = 0; i <dr.length; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					//과거의 C 값과 비교하기 위한 
					
	
					if( nc >= 0 && nc < strArr.length) {
						if(nc != preC) {
							if(strArr[nr][nc].equals("1")) {
								//이전 값의 C의 현재 c를 넣어줌
								preC = c;
								//c값에 바뀐 nc를 넣어줌
								c = nc;
								//System.out.println(r+" "+c +" "+preC+" "+changC);
								break;
							}
						}
					}
				}
				if(changC == c) {
					//System.out.println(r);
					preC = c;
					r-=1;
				}
			}
			System.out.printf("#%d %d\n",num,c);
		}
		br.close();
	}
}
