import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		//듣도 못한 사람의 수 N
		//보도 못한 사람의 수 M
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N+M; i++) {
			String name = br.readLine();
			if(!map.containsKey(name)) {
				map.put(name, 1);
			}else {
				map.put(name, map.get(name)+1 );
			}
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(String key : map.keySet()) {
			if(map.get(key) > 1) {
				list.add(key);
			}
		}
		Collections.sort(list);
		
		System.out.println(list.size());
		StringBuffer sb = new StringBuffer();
		for(String name : list) {
			sb.append(name +"\n");
		}
		System.out.println(sb);
	}

}