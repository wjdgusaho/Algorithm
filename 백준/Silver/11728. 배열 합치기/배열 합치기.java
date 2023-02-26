import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	
		int[] newArray = IntStream.concat(Arrays.stream(A), Arrays.stream(B)).toArray();
	
		Arrays.sort(newArray);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < newArray.length; i++) {
			sb.append(newArray[i]+" ");
		}
		System.out.println(sb);
			
	}

}