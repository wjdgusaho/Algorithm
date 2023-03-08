import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String[] tmp = str.split("-");
		//System.out.println(Arrays.toString(tmp));
		
		for(int i = 0; i < tmp.length; i++) {
			if(tmp[i].contains("+")) {
				String[] strTmp = tmp[i].split("\\+");
				//System.out.println(Arrays.toString(strTmp));
				int sum =0;
				for(int j = 0; j < strTmp.length; j++) {
					sum += Integer.parseInt(strTmp[j]);
				}
				tmp[i] = String.valueOf(sum);
			}
		}
		
		//System.out.println(Arrays.toString(tmp));
		int ans = Integer.parseInt(tmp[0]);
		for(int i = 1; i <tmp.length; i++) {
			ans -= Integer.parseInt(tmp[i]);
		}
		System.out.println(ans);
	}
}