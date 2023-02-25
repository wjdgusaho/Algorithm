import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	public static class listsort implements Comparator<int[]>{
		
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[0] == o2[0]) return o1[1] - o2[1];
			return o1[0] - o2[0];
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> lt = new ArrayList<>();
		
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lt.add( new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		
		Collections.sort(lt, new listsort());
				
		for(int[] tmp : lt) {
			System.out.println(tmp[0]+" "+tmp[1]);
		}
	}
}