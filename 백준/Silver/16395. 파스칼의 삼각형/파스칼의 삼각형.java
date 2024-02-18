import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] map = new int[N+1][N+1];
		map[1][1] = 1;
		for(int i = 2; i < N+1; i++ ) {
			for(int j = 1; j <= i; j++ ) {
				map[i][j] = map[i-1][j-1] + map[i-1][j];
			}
		}
		System.out.println(map[N][K]);
	}
}