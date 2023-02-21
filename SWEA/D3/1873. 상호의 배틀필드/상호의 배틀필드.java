import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	문자	의미
	.	평지(전차가 들어갈 수 있다.)
	*	벽돌로 만들어진 벽
	#	강철로 만들어진 벽
	-	물(전차는 들어갈 수 없다.)
	^	위쪽을 바라보는 전차(아래는 평지이다.)
	v	아래쪽을 바라보는 전차(아래는 평지이다.)
	<	왼쪽을 바라보는 전차(아래는 평지이다.)
	>	오른쪽을 바라보는 전차(아래는 평지이다.)	
	
	문자	동작
	U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
	D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
	L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
	R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
	S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.

*/
public class Solution {
	 
	
	static int r , c, dr, dc;  //전차 위치 r c 전차가 바라보는 위치 dr dc
	static char[][] map;
	static int H, W;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][];
			
			for(int h = 0; h < H; h++) map[h]= br.readLine().toCharArray();
			
			int N = Integer.parseInt(br.readLine());
			
			char[] user = br.readLine().toCharArray();
			
			//전차의 위치 탐색
			outer: 
			for(int h = 0; h < H; h++) {
				for(int w = 0; w < W; w++) {
					if(map[h][w] == '^'){
						r = h; 
						c = w;
						dr = -1;	//위쪽으로 이동하게 된다면
						dc = 0;     //값의 변화
						break outer;
					}
					if(map[h][w] == 'v') {
						r = h; 
						c = w;
						dr = 1;	//아래쪽 으로 이동하게 된다면
						dc = 0;     //값의 변화
						break outer;
						
					}
					if(map[h][w] == '<') {
						r = h; 
						c = w;
						dr = 0;	//왼쪽으로 이동하게 된다면
						dc = -1;     //값의 변화
						break outer;
						
					}
					if(map[h][w] == '>') {
						r = h; 
						c = w;
						dr = 0;	//오른쪽 으로 이동하게 된다면
						dc = 1;     //값의 변화
						break outer;
						
					}
				}
			}
			
			//4방 탐색을 해야할거같다!
			for(int i = 0; i< N; i++) {
				switch(user[i]){
				case 'U':		// 방향 위쪽 변경  
					rotate(-1, 0, '^');
					check();	// 평지 라면 한칸 이동
					break;
				
				case 'D':		// 바향 아래쪽 변경  - 평지 라면 한칸 이동
					rotate(1, 0, 'v');
					check();	// 평지 라면 한칸 이동
					break;
					
				case 'L':		// 방향 왼쪽 변경  - 평지 라면 한칸 이동
					rotate(0, -1, '<');
					check();	// 평지 라면 한칸 이동
					break;
				
				case 'R':		// 방향 오른쪽 변경   - 평지 라면 한칸 이동
					rotate(0, 1, '>');
					check();	// 평지 라면 한칸 이동
					break;
				
				case 'S':		// 포탄 발사!!!
					boom();
					break;
				}				
			}
			
			//System.out.println("r " + r + " c " + c);
			//System.out.println("N "+ N +" H "+ H+ " W "+ W);
			//System.out.println("map : " + Arrays.deepToString(map));
			//System.out.println("user : " + Arrays.toString(user));
			
			System.out.print("#"+t+" ");
			for(int h = 0; h < H; h++) {
				for(int w = 0; w < W; w++) {
					System.out.print(map[h][w]);
				}
				System.out.println();
			}
		}
	}
	
	private static void boom() {
		
		int nr = r+dr;
		int nc = c+dc;
		
		while(nr >= 0 && nr < H && nc >= 0 && nc < W) {
		
			if(map[nr][nc] == '*') {
				map[nr][nc] = '.';
				break;
			}
			if(map[nr][nc] == '#') {
				break;
			}
			
			nr = nr + dr;	//모든가 다 아니라면 반복 돌려야하니깐~
			nc = nc + dc;
		}
		
	}

	private static void rotate(int newDr, int newDc, char direc){
		map[r][c] = direc;		// 바라 보는 방향 변경
		dr = newDr;			// 만약에 이동한다면 값을 더해줄 dr값 변경
		dc = newDc;			// 만약에 이동한다면 값을 더해줄 dc값 변경
	}
	
	private static void check() {
		int nr = r+dr;
		int nc = c+dc;
		
		if(nr >= 0 && nr < H && nc >= 0 && nc < W) {
			if(map[r+dr][c+dc] == '.') {
				map[nr][nc] = map[r][c]; // 이동!
				map[r][c] = '.';		 //이동하니 평지로 변경
				r = nr;					 // r 값 이동 했으니 변경
				c = nc;					 // c 값 이동 했으니 변경
			}
		}
	}

}