import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	
	static char[] signOpen = { '(', '[' };
	static char[] signClose ={ ')', ']' };
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String tmp = br.readLine();
			if(tmp.equals(".")) break;
			
			char[] strC = tmp.toCharArray();
			String ans = check(strC);
			
			System.out.println(ans);
		}
	}
	
	private static String check(char[] strC) {
		
		Stack<Character> stack = new Stack<>();
	
		//괄호 비교를 위해 두번
		
		//strC 를 확인하기위해
		for(int i = 0; i < strC.length; i++) {
			for(int j = 0; j < 2; j++ ) {	
				if(strC[i] == signOpen[j]) {
					stack.push(strC[i]);
				}
				
				if(strC[i] == signClose[j]) {
					if(stack.isEmpty()) return "no";
					char tmp = stack.pop();
					
					for(int k = 0; k < 2; k++) {
						if(tmp == signOpen[k]) {
							if(j != k) return "no";
						}
					}
				}
				
			}
		}
	
		if(!stack.isEmpty()) return "no";
		if(strC[strC.length-1] != '.') return "no";
			
		return "yes";
	}
}