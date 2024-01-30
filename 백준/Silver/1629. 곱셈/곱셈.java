import java.util.*;
import java.io.*;

public class Main {
	
	public static int A, B, C;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long result = cut(B);
		System.out.println(result);
	}
	
	public static long cut(int n) {
		
		if(n == 1) return A%C;
		
		long tmp = cut(n/2)%C;
		
		if(n%2 == 0) return tmp*tmp%C;
		else return tmp*tmp%C*A%C;
		
	}
}