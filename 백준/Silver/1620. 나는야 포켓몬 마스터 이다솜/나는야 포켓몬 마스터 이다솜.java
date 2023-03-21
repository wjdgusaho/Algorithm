import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> Strmap = new HashMap<Integer, String>();
		Map<String, Integer> Intmap = new HashMap<String, Integer>();
		
		for(int n = 0; n < N; n++) {
			String tmp = br.readLine();
			Strmap.put(n+1, tmp);
			Intmap.put(tmp, n+1);
		}
		
		StringBuffer sb = new StringBuffer();
		for(int m = 0; m < M; m++) {
			String tmp = br.readLine();
			if(Intmap.containsKey(tmp)) {
				sb.append(Intmap.get(tmp)+"\n");
			}else {
				sb.append( Strmap.get(Integer.parseInt(tmp))+"\n");
			}
		}
		bw.append(sb);
		bw.close();
		br.close();
	}
	
}