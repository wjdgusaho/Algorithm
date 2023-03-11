import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Main {
	
	/*
	 
	  통계학 에서 N 개의 수를 대표하는 
	  기본 통계값에는 다음과 같은 것이 있다
 	  단 . N은 홀수
 	  
 	 산술 평균 : N 개의 수들의 합을 N으로 나눈 값
 	 -> 입력 받으면서 더하고 더한값의 평균
 	 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위차하는 값
 	 -> 정렬 중앙값
 	 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 	 -> map
 	 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 	 -> 최대값 과 최솟값의 차이 
 	 
 	 네가지 기본 통계값을 구하는 프로그램
 	 
	  첫재쭐  수의 개수 N
	 단 N은 홀수
	 N개의 줄에는 정수
	 입력되는 정수의 절대값은 4000을 넘지 않느다.
	 
	 첫째 줄에는 산술평균 ( 소수 첫쨰짜리에서 반올림 )
	 둘째 줄에는 중앙값
	 셋째 줄에는  최빈값 ( 여러개시 두번째로 작은값 )
	 넷쨰 줄에는 범위를 출력
	 
	 
	 */
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//맵
		Map<Integer, Integer> map = new HashMap<>();
		//배열 
		int[] nums = new int[N];
		
 		int sum = 0;
		for(int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			//산술평균을 위해 
			sum += tmp;
			//중앙값과 최빈값을 위해
			nums[i] = tmp;
			
			//만약 입력 받은 값의 키가 있따면 
			if(map.containsKey(tmp)) {
				//해당 키의 값을 1을 더한다
				map.put(tmp, map.get(tmp) + 1);
			}else {
			//map 입력받은값 ,  카운트 
			map.put(tmp, 1);
			}
		}
		
		//nums를 정렬 
		Arrays.sort(nums);
		//산술 평균값
		float avg = (float)sum / (float)N;
		System.out.println(Math.round(avg));
		//중앙값
		System.out.println(nums[N/2]);
		//최빈값
		//최빈값을 찾기위한 리스트
		
		int max = -1;
		for(int key : map.keySet()) {
			int value = map.get(key);
			//map 빼온 카운트 값이 max보다 크다면!
			if(max < value) {
				max = value;
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int key : map.keySet()) {
			int value = map.get(key);
			//map 빼온 카운트 값이 max보다 크다면!
			if (value == max) {
				list.add(key);
			}
		}
		
		Collections.sort(list);
	
		if(list.size() > 1) {
			System.out.println(list.get(1));
			
		}
		else {
			System.out.println(list.get(0));
		}
		
		//범위
		System.out.println(nums[nums.length-1]-nums[0]);
		
	}
}