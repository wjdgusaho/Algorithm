import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static class listsort implements Comparator<String[]>{
		@Override
		public int compare(String[] o1, String[] o2) {
			if(o1[0].equals(o2[0])) o1[2].compareTo(o2[2]);
			return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String[]> list = new ArrayList<>();
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new String[] {st.nextToken(), st.nextToken(), Integer.toString(cnt++)});		
		}
		
		Collections.sort(list, new listsort());
		
		for(String[] tmp : list) {
			System.out.println(tmp[0] +" "+ tmp[1]);
		}
	}
}