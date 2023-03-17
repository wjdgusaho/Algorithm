import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	// 나무 M미터가 필요
	// 절단기 H 지정
	// 높이 H보다  큰 나무는 H 부분이 잘리고 작으면 안잘린다.
	// 나무 높이  20 15 10 17  H = 15로 지정
	// 15 15 10 15  = 잘린 5와 2를 가지고 간다 ( 7 m )
	
	// 적도오 M미터의 나무를 집에 가져가기위에 설정할수있는 높이의 최댓값
	// H를 구해라
	// 
	// 4 7
	// 20  15  10  17
	// 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//나무수 
		int N = Integer.parseInt(st.nextToken());
		//가져가려는 길이 
		long M = Long.parseLong(st.nextToken());
		
		long[] arr = new long[N];
		
		arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		
		Arrays.sort(arr);
		
		long start = 0;
		long end = arr[N-1];
		
		long maxHeight = 0;
		while(start <= end) {
			
			long mid = (end-start)/2;
			//높이
			mid = start+mid;
			
			long sum = 0;
			for(int i = 0; i < N; i++) {
				sum += ((long)(arr[i])-mid)>0?(long)(arr[i])-mid:0;
			}
			//System.out.println(mid+"   "+start);
			//System.out.println(sum);
			//잘려서 남은 길이가 내가 가져가라는것보다 크거나 같거나 크다면!
			if(sum >= M) {
				//필요한 만큼만 가져갈거니깐 같으면 끝내버려!
				if(M <= sum) {
					if(maxHeight < mid)maxHeight = mid;
					//같지않으면 시작값 변경해줘
				}
				start = mid+1;
				
				
			}else {
				end = mid-1;
			}	
		}
		System.out.println(maxHeight);
	}

}