import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> MaxPq = new PriorityQueue<Integer>((o1, o2)-> o2-o1);
		PriorityQueue<Integer> MinPq = new PriorityQueue<Integer>();
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());	
			
			//사이즈를 비교 (동일하다? -> MAX 에추가 ) / 다르다 MIN에 추가 
			int MaxPqSize = MaxPq.size();
			int MinPqSize = MinPq.size();
			
			if(MaxPqSize == MinPqSize) MaxPq.offer(tmp);
			else MinPq.offer(tmp);
				
			//만약 높은순힙이 더 크면 Min과 변경
			//(MAX) -99 -10 1 5 <-peek /   / peek -> 10 12 15 20 (MIN)  <- 이런식 정렬하기 위해 (그럼 가운데 값 찾기쉬움)
			if( i != 0 && MaxPq.peek() > MinPq.peek()) {
				int A = MaxPq.poll();
				int B = MinPq.poll();
				
				MinPq.offer(A);
				MaxPq.offer(B);
			}
			
			sb.append(MaxPq.peek() + "\n");
		}
		System.out.println(sb);
	}
	
}