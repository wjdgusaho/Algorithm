import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < N; i++) {
			for(int j = N-1; j > i; j--) {
				sb.append(" ");
			}
			for(int j = 0; j <= i*2; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}