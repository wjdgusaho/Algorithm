import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int W, H, ans;
	public static void main(String[] args) throws IOException {
		//현재 위치 양옆에 자신보다 크냐 ?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		ans = 0;
		//맨앞과 맨뒤는 못하니깐
		for(int w = 1; w < W-1; w++) {
			check(w);
		}
		System.out.println(ans);
	}

	//좌우 체크
	static int[] dc = {-1, 1};
	private static void check(int c) {
		//왼쪽
		int Lcnt = 0;
		int nc = c + dc[0];
		while(true) {
			if(arr[nc] <= arr[c]+Lcnt) nc += dc[0];
			if(nc < 0) break;
			if(Lcnt+1 > H) break;
			if(arr[nc] > arr[c]+Lcnt) Lcnt++;	
		}
		int Rcnt = 0;
		nc = c + dc[1];
		while(true) {
			if(arr[nc] <= arr[c]+Rcnt) nc += dc[1];
			if(nc >= W) break;
			if(Rcnt+1 > H) break;
			if(arr[nc] > arr[c]+Rcnt) Rcnt++;
			
		}
		int min = Math.min(Lcnt, Rcnt);
		ans += min;
		arr[c] += min;
	}
}