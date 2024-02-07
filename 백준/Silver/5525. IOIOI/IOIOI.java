import java.util.*;
import java.io.*;

public class Main {

	public static int N, M, lastIndex;
	public static char[] arr;
	public static int[] findIdx;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = br.readLine().toCharArray();
		findIdx = new int[M];
		
		find();
		if(N == 1) System.out.println(lastIndex);
		else check();
	}
	
	public static void find() {
		
		int index = 0;
		for(int i = 0; i < M-2; i++) {
			if(arr[i] == 'I' && arr[i+1] == 'O' && arr[i+2] == 'I') findIdx[index++] = i;
		}
		lastIndex = index;
	}

	public static void check() {
		int result = 0;
		for(int i = 0; i < lastIndex - (N-1); i++) {
			int cnt = 0;
			for(int j = i; j < i+N; j++) {
				if(cnt == 0) cnt++;
				else if (findIdx[j] - findIdx[j-1] == 2)cnt++;
				else break;
			}
			if(cnt == N) result++;
		}
		System.out.println(result);
	}
}