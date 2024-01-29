import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toUpperCase().toCharArray();
		
		int[] count = new int[26];
		
		for(char tmp : text ) {
			count[tmp - 65]++;
		}
		
		int max = 0;
		int index = 0;
		int maxCnt = 0;
		for(int i = 0; i < count.length; i++) {
			if(count[i] > max) {
				max = count[i];
				index = i;
				maxCnt = 0;
			}
			else if(max == count[i]) {
				maxCnt++;
			}
		}
		if(maxCnt > 0) System.out.println("?");
		else {
			char result = (char)(index + 65);
			System.out.println(result);
		}
	}

}