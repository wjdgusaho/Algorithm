import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String tmp = "";
		while(((tmp = br.readLine()) != null)&&(tmp.length()>0)) {
			sb.append(tmp + "\n");	
		}
		System.out.println(sb);
	}
}