import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			Map<String, Integer>map = new HashMap();
			int[] count = new int[N];
			//데이터 입력
			int index = 0;
			for(int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String key = st.nextToken();
				if(map.containsKey(key)) {
					count[map.get(key)]++;
				}
				else {
					map.put(key, index);
					count[index++] = 2;
				}
			}
			int result = 1;
			for(int i = 0; i < index; i++) {
				result *= count[i];
			}
			sb.append((result-1)+"\n");  //모든걸 다 안입은거일경우 1빼준다
		}
		System.out.println(sb);
		
	}
	
}