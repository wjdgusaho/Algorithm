import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> dec = new ArrayList<>();
		
		for(int n = 0; n < N; n++) {
			
			String[] command = br.readLine().split(" ");
			
			
			if(command[0].equals("push_front")) {
				dec.add(0, Integer.parseInt(command[1]));
			}
			if(command[0].equals("push_back")) {
				dec.add(Integer.parseInt(command[1]));	
			}
			if(command[0].equals("pop_front")) {
				if(dec.isEmpty()) System.out.println("-1");
				else {
					System.out.println(dec.get(0));
					dec.remove(0);
				}
			}
			if(command[0].equals("pop_back")) {
				if(dec.isEmpty()) System.out.println("-1");
				else {
					System.out.println(dec.get(dec.size()-1));
					dec.remove(dec.size()-1);
				}
			}
			if(command[0].equals("size")) {
				System.out.println(dec.size());
			}
			if(command[0].equals("empty")) {
				System.out.println(dec.isEmpty()?1:0);
			}
			if(command[0].equals("front")) {
				if(dec.isEmpty()) System.out.println("-1");
				else System.out.println(dec.get(0));
			}
			if(command[0].equals("back")) {
				if(dec.isEmpty()) System.out.println("-1");
				else System.out.println(dec.get(dec.size()-1));
			}	
		}
	}
}