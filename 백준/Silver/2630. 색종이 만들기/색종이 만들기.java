import java.util.*;
import java.io.*;

public class Main {
	
	public static int[][] map;
	public static int N, blue, white;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		cut(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	
	public static void cut(int r, int c, int size) {
		//1 또는 0이니깐
		int sum = 0;
		for(int i = r, rEnd = r+size; i < rEnd; i++) {
			for( int j = c, cEnd = c+size; j < cEnd; j++) {
				sum += map[i][j];
			}
		}
		//모두 1인경우
		if(sum == size * size) {
			blue++;
		}
		//모두 0인경우
		else if(sum == 0) {
			white++;
		}
		//혼합인경우
		else {
			//4분할
			int half = size/2;
			cut(r, c, half);
			cut(r, c + half , half);
			cut(r + half , c , half);
			cut(r + half, c + half, half);
		}
		
	}	
}