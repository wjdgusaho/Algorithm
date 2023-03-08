import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int q, index;
		Node(int q, int index){
			this.q = q;
			this.index = index;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
		
	    for(int t = 0; t < T; t++) {
	    	
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	
	    	int N = Integer.parseInt(st.nextToken());
	    	int M = Integer.parseInt(st.nextToken());
	    	
	    	int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    	
	    	Queue<Node> que = new LinkedList<Node>();
	    	
	    	for(int i = 0; i < N; i++) que.offer(new Node(num[i], i));
	    	
	    	int cnt = 0;
	    	while(!que.isEmpty()) {
	    		Node tmp = que.poll();
	    		
	    		boolean check = true;
	    		for(int i = 0; i < N; i++) {
	    			//큰값이 있으면 ! 큐에 집어넣고 반복문 끝내
	    			if(num[i] > tmp.q ) {
	    				que.offer(tmp);
	    				check = false;
	    				break;
	    			}
	    		}
	    		//위에 나보다 큰게 없다면
	    		if(check) {
	    			num[tmp.index] = -1;
	    			++cnt;
	    			//정답 출력 
	    			if(tmp.index == M) {
	    				System.out.println(cnt);
	    				//while문 끝내!!
	    				break;
	    			}
	    		}
	    	}
	    }
	}
}