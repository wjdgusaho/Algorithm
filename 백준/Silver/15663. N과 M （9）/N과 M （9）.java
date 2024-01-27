import java.util.*;
import java.io.*;

public class Main {
	
	public static int N, M;
	public static int[] arr, number;
	public static boolean[] visited, check;
	public static StringBuffer sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuffer();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		number = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		perm(0, check);
		System.out.println(sb);
	}
	
	public static void perm(int cnt, boolean[] check) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(number[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		int preNum = -1;
		
		for(int i = 0; i < N; i++) {	
			if(visited[i] || preNum == arr[i])continue;
			number[cnt] = arr[i];
			visited[i] = true;
			preNum = arr[i];
			perm(cnt+1, check);
			visited[i] = false;
		}
		
	}

}