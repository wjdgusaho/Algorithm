import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer> que = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
		    String command = st.nextToken();
			
		    int Pnum;
		    if(command.equals("push")) { 
		    	Pnum = Integer.parseInt(st.nextToken());
		    	que.add(Pnum);
		    }
		    
		    if(command.equals("pop")) {
		    	if(que.isEmpty()) System.out.println(-1);
		    	else System.out.println(que.remove(0));
		    }
		    
		    if(command.equals("size")) {
		    	System.out.println(que.size());
		    }
		    
		    if(command.equals("empty")) {
		    	if(que.isEmpty()) System.out.println(1);
		    	else System.out.println(0);
		    }
		    
		    if(command.equals("front")) {
		    	if(que.isEmpty()) System.out.println(-1);
		    	else System.out.println(que.get(0));
		    }
		    
		    if(command.equals("back")) {
		    	if(que.isEmpty()) System.out.println(-1);
		    	else System.out.println(que.get(que.size()-1));	
		    } 
		}
	}
}