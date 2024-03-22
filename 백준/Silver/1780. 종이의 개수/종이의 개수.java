import java.util.*;
import java.io.*;

public class Main {
	
	public static int[][] map;
	public static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		result = new int[3];
		
		for(int i = 0; i < N; i++) {
		 map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		cut(0, 0, N);
		for(int i = 0; i < 3; i++) {
			System.out.println(result[i]);
		}
		
	}
	
	public static void cut(int r, int c, int n) {
		
		if(check(r, c, n)){
			int index = map[r][c] + 1;
			result[index] += 1;
			return;
		}
		
		int nextNum = n/3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cut(r + i * nextNum, c + j * nextNum, nextNum);
			}
		}
		
	}
	
	public static boolean check(int r, int c, int n) {
		
		int startNum = map[r][c];
		
		for(int i = r; i < r + n; i++) {
			for(int j = c; j < c + n; j++) {
				if(startNum != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
}