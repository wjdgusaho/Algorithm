import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		int[][] sortValueArr = new int[N][2];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i][0] = i;	//인덱스
			arr[i][1] = Integer.parseInt(st.nextToken());  //값
		}
		//System.out.println(Arrays.deepToString(arr));
		//배열 복사
		for(int i = 0; i < N; i++) {
			sortValueArr[i] = Arrays.copyOf(arr[i], 2);
		}
		
		//복사 배열 값 기준으로 정렬
		Arrays.sort(sortValueArr,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		//System.out.println(Arrays.deepToString(sortValueArr));
		
		//복사 배열 값의 인덱스 번호[0]의 기존arr[1]의 값을 랭킹으로 변경 ( 및 랭킹 )
		int preVale = Integer.MAX_VALUE;
		int lank = 0;
		for(int i = 0; i < N; i++) {
			//만약 0번째 아니고 값이 같이 않다면? 랭크 증가 
			if(i > 0 && preVale != sortValueArr[i][1]) {
				lank++;
			}
			//이전 값 저장
			preVale = sortValueArr[i][1];
			//정렬된 배열의 인덱스번호에 위치한 arr의 값을 정렬된 랭크값으로 변경 
			arr[sortValueArr[i][0]][1] = lank;
		}
		//System.out.println(Arrays.deepToString(arr));
		//정답은 arr[1] 랭크값이된다.
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < N; i++) {
			sb.append(arr[i][1] + " ");
		}
		System.out.println(sb);
	}
}