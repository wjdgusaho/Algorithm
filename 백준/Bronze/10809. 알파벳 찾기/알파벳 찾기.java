import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] result = new int[26];	
		for(int i = 0; i < 26; i++)result[i] = -1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
	
		for(int i = 0; i < text.length; i++) {
			int num = text[i]-97;
			if(result[num] == -1) {
				result[num] = i; 
			}
		}
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}	
	}
}