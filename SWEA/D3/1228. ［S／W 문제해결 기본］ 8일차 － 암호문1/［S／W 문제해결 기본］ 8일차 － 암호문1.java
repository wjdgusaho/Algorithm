import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = 10;
		for(int t = 0; t < T; t++ ) {
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			LinkedList<String> lList = new LinkedList<>();
			
			while(st.hasMoreTokens()) {
				lList.add(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			String[] command  = br.readLine().split("I");
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(command[m+1]);
				//+1 해주는 이유는 0번 인덱스에 null값이 들어가면서 잘림
				
				List<String> tmp = new ArrayList<>();
				while(st.hasMoreTokens()) {
					tmp.add(st.nextToken());
				}
		
				int num = Integer.parseInt( (tmp.get(0)) );
				tmp.remove(0);
				int count = Integer.parseInt( (tmp.get(0)) );
				tmp.remove(0);
				
				for(int i = 0; i < count; i++) {
					lList.add(num+i, tmp.get(i));
				}
				tmp.clear();
			}
			sb.append("#"+(t+1));
			for(int i = 0; i < T; i++) {
				sb.append(" "+lList.get(i));
			}
			sb.append("\n");
			lList.clear();
		}
		System.out.println(sb.toString());
	}
}
