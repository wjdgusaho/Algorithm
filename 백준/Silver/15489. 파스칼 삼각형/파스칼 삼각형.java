import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R+W+1][R+W+1];
		map[1][1] = 1;
		for(int i = 2; i <= R+W; i++ ) {
			for(int j = 1; j <=i ; j++) {
				map[i][j] = map[i-1][j-1] + map[i-1][j];
			}
		}
		
		int sum = 0;
		for(int i = 0; i < W; i++) {
			for(int j = 0; j <=i; j++) {
				sum += map[R+i][C+j];
			}
		}
		System.out.println(sum);
	}

}