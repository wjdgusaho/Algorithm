import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, K;
	static List<Integer>[][] map;
	static Misangmul[] ms;
	static List<int[]> dupList;

	static class Misangmul {
		int r, c, cnt, d;

		public Misangmul(int r, int c, int cnt, int d) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.d = d;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= Tc; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			//List 타입의 2차원 배열 생성
			map = new ArrayList[N][N];
			dupList = new ArrayList<>();
			//각 배열에 리스트 값 할당
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = new ArrayList<Integer>();
				}
			}

			// 미생물 정보 입력받기
			ms = new Misangmul[K];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				ms[i] = new Misangmul(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			//초기값을 map에 넣을경우 reset을 시켜줘야한다! ( 화면출력 할예정이 아니면 굳이 초기값을 넣어줄필요 없어 생략 )
			
			//반복
			while(M-->0) {
				move();		//이동해 (이동하고 -> 방향 변경 )
				check();	//중복된 값이 있으면 합치는 메소드
				reset();	//맵 + 중복 리스트 초기화
			}
			
			//최종 미생물 개수 카운트
			int ans = 0;
			for(int i = 0; i < K; i++) {
				if(ms[i].r == -1) continue; //사용하지 않는 인덱스이므로 넘어간다.
				ans += ms[i].cnt;
			}
			//결과 출력
			System.out.println("#"+tc+" "+ans);
		}

	}
	
	private static void reset() {
		
		//맵 초기화 
		for(int i = 0; i < K; i++) {
			if(ms[i].r == -1)continue;
			map[ms[i].r][ms[i].c] = new ArrayList<>();
		}
		//중복 리스트 사용 했으니 초기화 
		dupList = new ArrayList<>();
		
	}

	//합쳐졌을때 중복 체크
	private static void check() {
		
		for(int[]tmp : dupList) {
			//중복체크를 위한 리스트에서 중복된 r과 c값이 tmp[]에 받아온다  
			int len =  map[tmp[0]][tmp[1]].size();	//tmp[0] = r | tmp[1] = c
			int sum = 0; 					//중복된 인덱스의 미생물 수 더하기 
			int max = Integer.MIN_VALUE; 	//중복된 인덱스중의 제일 큰 값을 알기위한 MAX
			int maxIdx = 0; 			 	//중복된 인덱스중 미생물수가 제일 많은 idx번호
			
			/* 
			//중복 체크 출력 
			System.out.println("중복리스트 체크 하겠습니다 ");
			System.out.println(tmp[0] + " " + tmp[1]+" 길이는 : " +len);
			System.out.println("------------------");
			System.out.print("중복 리스트는 : ");
			*/
			
			for(int i = 0; i < len; i++) {
				
				int idx = map[tmp[0]][tmp[1]].get(i);	//r c 해당 맵 안 리스트에 있는 값은
				sum += ms[idx].cnt;
				if(ms[idx].cnt > max) {
					max = ms[idx].cnt;
					maxIdx = idx;
				}
				//마지막 값이라면
				if(i == len-1) {
					ms[idx].cnt = sum;			//마지막 위치면 마지막 인덱스에 지금까지 더한 값을 넣어준다
					ms[idx].d = ms[maxIdx].d; 	//마지막 인덱스의 방향을 제일 높은 미생물을 가졌던거로 변경
				}
				else {
					ms[idx].r = -1;	//마지막 값이 아니면 합쳐질 거기때문에 사용하지 않을거라는 -1 값 설정
				}
			}
			//System.out.println("최종 값은 : " + ms[map [ tmp[0] ][ tmp[1] ].get(len-1)].cnt);
		}
		
	}

	private static void move() {
		//0번 인덱스 사용하지 않기 위해 상하 좌우
		// 1 상 2하  3좌  4우
		int[] dr = {0, -1, 1, 0, 0};
		int[] dc = {0, 0, 0, -1, 1};
		
		//미생물 이동
		for(int i = 0; i < K; i++) {
			if(ms[i].r == -1) continue; //사용하지 않는 인덱스이므로 넘어간다.
			
			int nr = ms[i].r + dr[ms[i].d];
			int nc = ms[i].c + dc[ms[i].d];
			
			
			if( nr == 0 || nr == N-1 || nc  == 0 || nc == N-1 ) {
				//방향 바꾸기
				if(ms[i].d == 1) ms[i].d = 2;
				else if(ms[i].d == 2) ms[i].d = 1;
				else if(ms[i].d == 3) ms[i].d = 4;
				else ms[i].d = 3;
				//값 나누기 (자바는 자동으로 소수점 버려짐 )
				ms[i].cnt = ms[i].cnt / 2; 
			}
		
			//약물이 있거나 없거나 이동해야하니깐
			//맵에 값 추가
			map[nr][nc].add(i);
			//방금 추가한곳에 size 1이상이라면 중복된 값이 있으니 체크해봐야하니 중복체크 리스트에 값 추가 (값 추가를 1번만 하면되니깐)
			if(map[nr][nc].size() > 1 && map[nr][nc].size() < 3) dupList.add(new int[] {nr, nc});
			
			ms[i].r = nr;
			ms[i].c = nc;
		}
		
		//print();	//진행과정 맵을 출력해볼때 사용

	}
	
	private static void print() {
		
		for(int i = 0; i < K; i++) {
			System.out.println(i + " " + ms[i].r + " " + ms[i].c + " " + ms[i].cnt + " " + ms[i].d);
		}
		
		//출력해보자
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() == 0)
					System.out.print("ㅁ");
				else {
					for (int tmp : map[i][j]) {
						System.out.print(tmp + "");
						System.out.print("("+ms[tmp].cnt+")");
					}
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("======================");
	}

}