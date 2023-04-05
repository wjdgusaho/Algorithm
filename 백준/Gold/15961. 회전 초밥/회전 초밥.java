import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//벨트의 놓인수
		int N = Integer.parseInt(st.nextToken());
		//초밥의 가짓수
		int d = Integer.parseInt(st.nextToken());
		//연속해서 먹는수
		int k = Integer.parseInt(st.nextToken());
		//쿠폰 번호
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+k+1];
		
		//배열 생성 1 ~ N+K 까지
		for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());
		int idx = N+1;
		for(int i = 0; i < k; i++) arr[idx++] = arr[i+1]; 
		
		//배열 잘 들어왔는지 확인
		//System.out.println(Arrays.toString(arr));
		
		//카운팅 배열 생성
		int[] counting = new int[d+1];
		//쿠폰은 무조건 먹을거니깐 counting 해두자
		counting[c] += 1;
		
		//카운팅 배열 생성 잘되었는 확인
		//System.out.println(Arrays.toString(counting));
	
		// 시작 포인트
		int start = 1;
		// 끝난는 위치
		int end = k;
		
		//초기값 중복 체크
		for(int i = start; i <= end; i++) {
			 counting[arr[i]] += 1;
		}
		
		//초기 카운팅 된 개수 확인!
		int ans = Integer.MIN_VALUE;
		int cnt = 0;
		for(int i = 1; i < d+1; i++ ) {
			if(counting[i] >= 1) cnt++;
		}
		
		/*
		System.out.println(Arrays.toString(counting));
		System.out.println("시작  "+ start + " 끝 " + end);
		System.out.println(cnt);
		System.out.println("-----------------");
		*/
		
		//총 갯수만큼 카운트 해주기 위해서
		//0부터 안하는 이유는 1번 인덱스 그런게 아니고 이미 위에서 1번 초기값 세팅을 해주었기 때문!
		for(int i = 1; i < N; i++) {
			
			ans = Math.max(cnt, ans);
			
			//만약에 카운팅 된 값 - 1 이 k값과 같다는것은 이미!! 최댓값을 먹었으니 끝내라
			if(cnt == k+1) break;
			
			//end 포인터 증가
			end += 1;
			//System.out.println(i +"번째 "+ "시작  "+ start + " 끝 " + end);
			//값이 같으면 추가되고 빠져도 cnt값은 그대로!
			if(arr[end] == arr[start]) {
				start+=1;
				continue;
			}
			//같지 않으니 해당위치 값 빼준다.
			counting[arr[start]] -= 1;
			//만약에 끝지점이 0보다 컸다면 (이미 선택되어 있는 상태 )
			if(counting[arr[start]] == 0) {
				cnt-=1;
			}
			if(counting[arr[end]] == 0) {
				//하나가 빠지고 중복된게 추가된 상태이니 cnt 1감소
				cnt+=1;
			}
			counting[arr[end]] += 1;
			//시작값 증가
			start+=1;
			
			/*
			System.out.println(Arrays.toString(counting));
			System.out.println(i +"번째 "+ "시작  "+ start + " 끝 " + end);
			System.out.println(cnt);
			System.out.println("-----------------");
			*/
		}
		System.out.println(ans);
	}

}