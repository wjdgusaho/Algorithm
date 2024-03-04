import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 28;
		boolean[] arr = new boolean[31];
		while(t --> 0) {
			int tmp = Integer.parseInt(br.readLine());
			arr[tmp] = true;
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= 30; i++) {
			if(arr[i]) continue;
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}

}