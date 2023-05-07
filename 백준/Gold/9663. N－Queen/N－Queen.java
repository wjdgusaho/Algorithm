import java.util.Scanner;

public class Main {

	static int N, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int[] map = new int[N];
		ans = 0;
		dfs(0, map);
		System.out.println(ans);
	}
	
	private static void dfs(int cnt, int[] map) {
		
		if(cnt == N) {
			ans+=1;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			map[cnt] = i;
			
			if(check(cnt, map) ) {
				dfs(cnt+1, map);
			}
		}
		
	}

	private static boolean check(int cnt, int[] map) {
		
		for(int i = 0; i < cnt; i++) {
			if(map[cnt] == map[i]) {
				return false;
			}
			else if(Math.abs(cnt-i) == Math.abs(map[cnt] - map[i])){
				return false;
			}
		}
		return true;
	}	
}