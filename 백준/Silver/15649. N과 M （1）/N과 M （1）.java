import java.util.Scanner;
public class Main {

	static int N;
	static int M;
	static boolean[] visited;
	static int[] numbers, inputs;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//숫자 갯수
		N = in.nextInt();
		//선택하는 갯수
		M = in.nextInt();
		
		//숫자를 사용하고있는가?
		visited = new boolean[N];
		
		//선택한 값이 들어갈 배열
		numbers = new int[M];
		
		//입력한 값의 배열
		inputs = new int[N];
		
		//숫자 추가
		for(int i = 0; i < N; i++) {
			inputs[i] = i+1;
		}
		perm(0);
	}
    
	private static void perm(int cnt) {
		
		if(cnt >= M) {
			for(int i = 0; i < M; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			
			//값을 사용중인지 체크 하고 사용중이면 continue
			if(visited[i]) continue;
			
			//값을 사용중이지 않았으니 사용중으로 변경
			visited[i] = true;
			
			//numbers에 visited값 
			numbers[cnt] = inputs[i];
			
			perm(cnt + 1);
			
			//peam 끝나고 돌아왔으니 사용하지 않음으로 변경
			visited[i] = false;
				
		}	
	}
}
