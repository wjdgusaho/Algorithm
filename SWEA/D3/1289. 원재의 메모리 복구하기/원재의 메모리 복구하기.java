import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			wonjae(in.readLine());
			System.out.printf("#%d %d\n", t+1, cnt);
			cnt = 0;
		}
	}

	static int cnt = 0;
	private static String wonjae(String num) {
		
		
		int idx = num.indexOf("1");
		if (idx == -1 ) return num;
		
		cnt++;
		String tmp = num.substring(idx, num.length());
		num = num.substring(0, idx);
		
		for(int i = 0; i < tmp.length(); i ++) {
			if(tmp.charAt(i) == 48) {
				num += "1";
			}else {
				num += "0";
			}
		}
		
		return wonjae(num);
		
	}	
	
}
