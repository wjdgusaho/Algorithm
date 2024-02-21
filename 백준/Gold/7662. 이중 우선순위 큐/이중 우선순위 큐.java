import java.io.*;
import java.util.*;

public class Main {	
	public static int Q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuffer sb = new StringBuffer();
		
		for(int t = 1; t <= T; t++) {
			TreeMap<Long, Long> treeMap = new TreeMap<>();
			Q = Integer.parseInt(br.readLine());

			for(int q = 0; q < Q; q++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char commend = st.nextToken().charAt(0);
				long value = Long.parseLong(st.nextToken());
				
				if(commend == 'I') {
					//getOrDefault 이미 들어있는 정수면 개수를 늘려주고 , 처음 넣는 점수면 1을 넣어준다
					treeMap.put(value, treeMap.getOrDefault(value, (long) 0)+1);
				}
				else{
					if(treeMap.size() > 0) {
						if(value == 1) {
							Long tmp = treeMap.get(treeMap.lastKey());  //최대값의 개수 (key - value의 value)
							if(tmp == 1) treeMap.remove(treeMap.lastKey());
							else treeMap.put(treeMap.lastKey(), tmp-1); //최대값의 개수를 -1 하나를 줄여줌
						}
						else {
							Long tmp = treeMap.get(treeMap.firstKey());  //최대값의 개수 (key - value의 value)
							if(tmp == 1) treeMap.remove(treeMap.firstKey());
							else treeMap.put(treeMap.firstKey(), tmp-1); //최대값의 개수를 -1 하나를 줄여줌
						}
					}
				}
			}
			
			if(treeMap.size() == 0) {
				sb.append("EMPTY\n");
			}
			else {
				sb.append(treeMap.lastKey() +" " + treeMap.firstKey() + "\n");
			}
		}
		System.out.println(sb);
	}
	
}