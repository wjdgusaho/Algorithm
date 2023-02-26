import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[] list, find;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//누가봐도 시간초가가 생길가능성이 농후
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		list = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			//int answer = BinarySearch(0, list.length-1, Integer.parseInt(st.nextToken()) );
			int answer = Arrays.binarySearch(list, Integer.parseInt(st.nextToken()) );
			if(answer >= 0) System.out.println(1);
			else System.out.println(0);
			
		}
		br.close();
		
	}
	/*
	public static int BinarySearch(int start, int end, int find) {
		
		int mid =  (end+start) /2;
		if(find == list[mid]) return 1;
		
		//마지막 값이 같으면 값이 없으면
		if(end == start) return 0;
		
		if(find < list[mid]) return BinarySearch(start, mid-1, find);
		else{
			return BinarySearch(mid+1, end, find);
		}
		
	}
	*/
}