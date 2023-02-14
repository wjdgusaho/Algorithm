import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] tmp;
	static int N, M, R;
	static Queue<Integer> que;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt( st.nextToken());
		tmp = new int[N][M];
		
		//입력 받으면서 int형으로 변환
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				tmp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//배열을 한줄로 변경!
		int MCont;
		int NCont;
		if(M%2==0) MCont = M/2;
		else MCont = M/2+1;
		if(N%2==0) NCont = N/2;
		else NCont = N/2+1;
		
		int Cont;
		if(NCont<MCont) Cont = NCont;
		else Cont = MCont;
		
		
		int[][] arr =  new int[Cont][];
		StringBuffer buffer = new StringBuffer();
		
		for(int i = 0; i < Cont; i++) {
			st = new StringTokenizer(test(i,i));
			
			int[] tokenTmp = new int[st.countTokens()];
			
			for(int j = 0; j < tokenTmp.length; j++ ) {
				tokenTmp[j] = Integer.parseInt(st.nextToken());
			}
			arr[i] = tokenTmp;
		}//드디어 한줄 만들기 끝! 
		
		
		//로테이션
		for(int i = 0; i<arr.length; i++) {
			RotaeQue(arr[i]);
			//배열 저장 
			ToArr(arr[i], i, i);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(tmp[i][j] +" ");
			}
			System.out.println();
		}
	}
	

	//한줄만들기
	static String test(int r, int c) {
		
		StringBuffer buffer = new StringBuffer();
		//오른쪾
		for(int i = c; i < M-c; i++) {
			buffer.append(tmp[r][i] + " ");
		}
		//아래
		for(int i = r+1; i < N-r; i++) {
			buffer.append(tmp[i][M-c-1]+" ");
		}
		//왼쪽
		for(int i = M-c-2; i >= c; i--) {
			buffer.append(tmp[N-r-1][i]+" ");
		}
		//위쪽
		for(int i = N-r-2; i > r; i--) {
			buffer.append(tmp[i][c]+ " ");
		}
		
		return buffer.toString();
	}

	//로케이션 돌리기
	static void RotaeQue(int[] arr) {
		
		que = new LinkedList<>();
		
		//큐에 값 집어 넣기!
		for(int i = 0; i < arr.length; i++) {
			que.offer(arr[i]);
		}

		//로테이션!
		for(int i = 0; i < R; i++) {
			int tmp = que.poll();
			que.offer(tmp);
		}
	
		/*
		//배열에 저장
		int[] rotateArr = new int[que.size()];
		for(int i = 0, size = que.size(); i < size ; i++) {
			rotateArr[i] = que.poll();
		}
		*/
		//return rotateArr;
	}
	
	//한줄을 배열로!

	private static void ToArr(int[] arr, int r, int c) {
		
		//오른쪽
		for(int i = c; i < M-c; i++) {
			tmp[r][i] = que.poll();
		}
		//아래
		for(int i = r+1; i < N-r; i++) {
			tmp[i][M-c-1] = que.poll();
		}
		//왼쪽
		for(int i = M-c-2; i >= c; i--) {
			tmp[N-r-1][i] = que.poll();
		}
		//위쪽
		for(int i = N-r-2; i > r; i--) {
			tmp[i][c] = que.poll();
		}	
	}

}
