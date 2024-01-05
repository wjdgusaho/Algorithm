import java.util.*;
import java.io.*;

public class Main {
	
	public static class Data implements Comparable<Data>{
		int start;
		int end;
		
		public Data(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Data o) {
			if(this.end == o.end ) return this.start - o.start;
			return this.end - o.end;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.offer(new Data(start, end));
		}
		
		int cnt = 0;
		int endCheck = 0;
		while(!pq.isEmpty()) {
			Data tmp = pq.poll();
			if(endCheck == 0) {
				cnt++;
				endCheck = tmp.end;
			}
			else {
				if(tmp.start >= endCheck) {
					endCheck = tmp.end;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}