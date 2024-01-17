import java.util.*;
import java.io.*;

public class Main {
	
	public static Set<Integer> set;
	public static StringBuffer sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		
		set = new HashSet<>();
		sb = new StringBuffer();
		
		for(int m = 0; m < M; m++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			String text = st.nextToken();
			int num = 0;
			if(st.hasMoreElements()) {
				num = Integer.parseInt(st.nextToken());
			}
			
			switch(text) {
				case "add":
					add(num);
					break;
				case "remove":
					remove(num);
					break;
				case "check":
					check(num);
					break;
				case "toggle":
					toogle(num);
					break;
				case "all":
					all();
					break;
				case "empty":
					empty();
					break;
			}
		}
		System.out.println(sb);
		
	}
	
	public static void add(int num) {
		if(!set.contains(num)) {
			set.add(num);
		}
	}
	
	public static void remove(int num) {
		if(set.contains(num)) {
			set.remove(num);
		}
	}
	
	public static void check(int num) {
		if(set.contains(num)) sb.append(1 + "\n");
		else sb.append(0 + "\n");
	}
	
	public static void toogle(int num) {
		if(set.contains(num)) set.remove(num);
		else set.add(num);
	}
	
	public static void all() {
		for(int i = 1; i <= 20; i++) {
			add(i);
		}
	}
	
	public static void empty() {
		set.clear();
	}
}