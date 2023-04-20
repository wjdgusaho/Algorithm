import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[]arr = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		boolean[] visited = new boolean[N+1];
		Set<Integer> treeSet = new TreeSet<>();
		
		for(int i = 1; i < N+1; i++) {
			if(visited[i])continue;
			visited[i] = true;
			//System.out.println(Arrays.toString(visited));
			//System.out.println(i + " " + arr[arr[i]]);
			if(i == arr[i]) treeSet.add(i);
			else if(i == arr[arr[i]]) {
				treeSet.add(i);
				treeSet.add(arr[i]);
				visited[arr[i]] = true;
			}
			else {
				boolean[] copyVisitd = visited.clone();
				List<Integer>list = new ArrayList<>();
				list.add(i);
				int j = arr[i];
				while(true) {
					//종료 조건
					if(copyVisitd[j]) {
						//사이클이라는 뜻
						//System.out.println("종료조건"+ j + " " + i);
						if(j == i) {
							for(int tmp : list) {
								treeSet.add(tmp);
								visited[tmp] = true;
							}
						}
						//while문 종료
						break;
					}
					copyVisitd[j] = true;
					list.add(j);
					j = arr[j];	
				}
			}
		}
		
		System.out.println(treeSet.size());
		for(int i : treeSet) {
			System.out.println(i);
		}	
	}
}