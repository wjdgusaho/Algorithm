import java.util.*;

public class Main {

	/*
		스택은 자료를 넣는 push 뽑는건 pop
		1부터 n까지의 수를 스택
	*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
	
		Stack<Integer> stack = new Stack();
		StringBuffer sb = new StringBuffer();
		
		int num = 0;
		for(int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			//System.out.print("tmp : " + tmp + " num " + num +" " );
			if(tmp > num) {
				for(int n = num + 1; n <= tmp; n++) {
					sb.append("+\n");
					stack.push(n);
					//System.out.print(" peek " + stack.peek() +" ");
				}
				num = tmp;
				//System.out.println();
			}
			else if(tmp != stack.peek()) {
				sb = new StringBuffer();
				sb.append("NO");
				break;
			}
			
			sb.append("-\n");
			stack.pop();
			
		}
		System.out.println(sb);
	}
}