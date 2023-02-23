import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class Main {
	
	static int N, M, chickenCnt, userCnt, answer = 1000000;
	static int[][] map;
	static int[] input, number;
	static ArrayList<int[]> chicken, user;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		chicken = new ArrayList<>();
		user = new ArrayList<>();
		
		//치킨집과 사람들의 거리 차이 
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 2) chicken.add(new int[] {chickenCnt++, i, j } );
				if(map[i][j] == 1) user.add(new int[] {userCnt++, i, j });
			}
		}
		
		//M개를 선택해보자!
		input = new int[chickenCnt];
		number = new int[M];
		for(int i = 0; i < chickenCnt; i++) input[i] = i;
		comb(0, 0);
		
		System.out.println(answer);	
	}
	
	private static void comb(int cnt, int start) {
		
		if(cnt == M) {
			//거리 계산
			distance();
			return;
		}
		
		for(int i = start; i < chickenCnt; i++) {
			number[cnt] = input[i];
			comb(cnt+1, i+1);
		}
	}
	
	private static void distance() {
		int[][] disMap = new int[M][userCnt];
		
		//조합에서 선택된 친구
		for(int i = 0; i < M; i++) {
			//치킨집 찾기!
			int[] chickenTmp = null;
				chickenTmp = chicken.get(number[i]);
	
			//user 위치
			for(int k = 0; k < userCnt; k++) {
				int [] userTmp = user.get(k);
				disMap[i][userTmp[0]]= Math.abs(chickenTmp[1] - userTmp[1]) + Math.abs(chickenTmp[2]-userTmp[2]);	
			}
		}
		//행 : 치킨 집 // 열 : 유저 
		//최솟값 다 더한값
		int minSum = 0;
		for(int c = 0; c < userCnt; c++) {
			int min = 1000000;
			//해당 집에서 제일 가까운 거리의 치킨집을 찾아  그거리를 min 삽입
			for(int r = 0; r < M; r++) {
				if(min > disMap[r][c]) min = disMap[r][c];
			}
			//min값 더하기
			minSum += min;
		}
		//정답 최저값인지 고체
		if(answer > minSum) answer = minSum;
	}
}