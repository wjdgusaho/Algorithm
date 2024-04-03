import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int t = 0; t < T; t++) {
			int M = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> MinHeap = new PriorityQueue<Integer>();
			PriorityQueue<Integer> MaxHeap = new PriorityQueue<Integer>((o1, o2)-> o2- o1);
			
			StringBuffer sbT = new StringBuffer(); 
			int cnt = 0;
			
			
			int level = M/10 + 1;
			int lastSize = M%10;
			int numCnt = 0;
			
			for(int m = 0; m < level; m++) {
	
				StringTokenizer st = new StringTokenizer(br.readLine());
				int N = m != level-1 ? 10 : lastSize;
				
				for(int n = 0; n < N; n++) {
					int tmp = Integer.parseInt(st.nextToken());
					numCnt++;
	
					if(MaxHeap.size() == 0) {
						MaxHeap.offer(tmp);
					}else {
						int MinSize =  MinHeap.size();
						int MaxSize =  MaxHeap.size();
						
						if( MinSize == MaxSize ) MaxHeap.offer(tmp);
						else MinHeap.offer(tmp);
						
						if(MinHeap.peek() < MaxHeap.peek()) {
							int A = MaxHeap.poll();
							int B = MinHeap.poll();
							MaxHeap.offer(B);
							MinHeap.offer(A);
						}
					}
					
					if( numCnt % 2 != 0) {
						cnt++;
						sbT.append(MaxHeap.peek() +" ");
						if(cnt%10 == 0) sbT.append("\n");
					}		
				}
				
			}
			sb.append(cnt +"\n" + sbT +"\n");
		}
		System.out.println(sb);
	}
}