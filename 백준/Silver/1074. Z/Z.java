import java.util.*;
import java.io.*;

public class Main {
	
	static int N, R, C, result;
	static boolean check;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
	
		int num = (int) Math.pow(2, N);
		result = 0;
		check = true;
		cut(0, 0, num, 0);
		System.out.println(result);
	}
	
	public static void cut(int r, int c, int n, int cnt) {
		//기저 조건
		if(n < 2) return;
		if(!check) return; 
		if(n == 2) {
			for(int i = r; i < r+2; i++) {
				for(int j = c; j < c+2; j++) {
					if(i == R && j == C) {
						check = false;
						result = cnt;
						return;
					}
					cnt++;
				}
			}
		}	
		int half = n/2;
		int tmp = half*half;
		if(r <= R && c <= C && r+half > R && c+half > C) cut(r, c, n/2, cnt);
		else if(r <= R && c+half <= C && r+half > R && c+(2*half) > C) cut(r, c+half, n/2, cnt+tmp);
		else if(r+half <= R && c <= C && r+(2*half) > R && c+half > C) cut(r+half, c, n/2, cnt+(tmp*2));
		else cut(r+half, c+half, n/2, cnt+(tmp*3));
	}
}