import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] minusArr = new int[101];
		int[] plusArr = new int[101];
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp < 0) {
				minusArr[Math.abs(tmp)] += 1;
			}
			else {
				plusArr[tmp]+=1;
			}
		}
		
		int find = Integer.parseInt(br.readLine());
		System.out.println(find < 0 ? minusArr[Math.abs(find)] : plusArr[find]);
		
	}

}