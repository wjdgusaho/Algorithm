import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M, T;
	static int[]p1;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		for(int t = 0; t < T; t++) {
			sb.append("#").append(t+1).append(" ");
			//sb.append("#"+(t+1)+" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			p1 = new int[N+1];
			
			makeSet();
			
			int[] num = new int[3];
			for(int i = 0; i < M; i++) {
				
				/*
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 3; j++) command[j] =  Integer.parseInt(st.nextToken());
				*/
				
				st = new StringTokenizer(br.readLine());
				int command =  Integer.parseInt(st.nextToken());
				int a =  Integer.parseInt(st.nextToken());
				int b =  Integer.parseInt(st.nextToken());
				
				if(command == 0) union(a, b);
				if(command == 1) {
					if(find(a) == find(b)) {
						sb.append("1");
					}else sb.append("0");
				}
				
				/*
				command = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
				if(command[0] == 0) union(command[1], command[2]);
				if(command[0] == 1) {
					if(p1[command[1]] == p1[command[2]]) {
						sb.append("1");
					}else sb.append("0");
				}
				*/
			}
			sb.append("\n");
		}
		bw.append(sb.toString());
		bw.close();
		br.close();
	}
	private static void union(int a, int b) {
		int tmpA = find(a);
		int tmpB = find(b);
		
		//합친다
		p1[tmpB] = tmpA;
	}
	
	private static int find(int a) {
	
		if(p1[a] == a) {
			return a;
		}
		
		return p1[a] = find(p1[a]);
	}
	
	private static void makeSet() {
		for(int i = 1; i <= N; i++) {
	            p1[i] = i;
	    }
	}
}