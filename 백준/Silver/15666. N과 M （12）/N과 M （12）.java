import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static Integer[] arr, number;
	static StringBuffer sb;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		number = new Integer[M];
		arr = set.toArray(new Integer[0]);
		Arrays.sort(arr);
		
		sb = new StringBuffer();
		
		comb(0, 0);
		System.out.println(sb.toString());
	}

	private static void comb(int cnt, int start) {

		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(number[i]);
				if(i != M-1)sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			number[cnt] = arr[i];
			comb(cnt+1, i);
		}
		
	}

}