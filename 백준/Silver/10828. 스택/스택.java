import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] stack = new int[100001];
	static int top;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		top = -1;
		
		for(int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
		    String command = st.nextToken();
		    int Pnum;
		    if(command.equals("push")) { 
		    	Pnum = Integer.parseInt(st.nextToken());
		    	stack[++top] = Pnum;
		    }
		    
		    if(command.equals("pop")) {
		    	if(top < 0) {
		    		System.out.println(-1);
		    	}
		    	else {
		    		System.out.println(stack[top]);
		    		stack[top--] = 0;
		    	}
		    }
		    
		    if(command.equals("size")) {
		    	System.out.println(top+1);
		    }
		    
		    if(command.equals("empty")) {
		    	if(top == -1) System.out.println(1);
		    	else System.out.println(0);
		    }
		    
		    if(command.equals("top")) {
		    	if(top < 0) System.out.println(-1);
		    	else System.out.println(stack[top]);
		    }
		}		
	}
}