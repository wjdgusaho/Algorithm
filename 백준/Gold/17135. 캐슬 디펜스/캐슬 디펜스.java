import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static class Enemy {
		int r, c;
		public Enemy(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M, D, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		List<Enemy> enemies = new LinkedList<>();
		// 1. 적들의 위치를 저장
		for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) if (sc.nextInt() == 1) enemies.add(new Enemy(i, j)); 
		
		// 2. 궁수의 위치를 선정(조합)
		for (int i = 0; i < M - 2; i++) {
			for (int j = i + 1; j < M - 1; j++) {
				for (int k = j + 1; k < M; k++) {
					List<Enemy> copyEnemies = new LinkedList<>();
					for (Enemy e : enemies) copyEnemies.add(new Enemy(e.r, e.c)); 
					
					// 궁수의 위치에서 적들을 모두 처치하자.
					killEnemies(copyEnemies, new int[] {i, j, k});
				}
			}
		}
		
		System.out.println(ans);
	}
	static void killEnemies(List<Enemy> copyEnemies, int[] archers) {
		int cnt = 0;
		while (!copyEnemies.isEmpty()) {
			Set<Enemy> removeEnemies = new HashSet<>();
			for (int archer : archers) {
				Enemy e = findEnemy(copyEnemies, archer);
				if (e != null) {
					removeEnemies.add(e);
				}
			}
			// 현재 턴에서 찾은 적들의 카운트 세기
			cnt += removeEnemies.size();
			// 현재 턴에서 찾은 적들을 리스트에서 제거
			copyEnemies.removeAll(removeEnemies);
			// 적들을 하강시키자..
			downEnemy(copyEnemies);
		}
		// 모든 적이 처치 되었다.
		ans = Math.max(ans, cnt);
	}
	static void downEnemy(List<Enemy> copyEnemies) {
		// 리스트를 반복하면서 적의 r의 자표를 증가시킨다.
		// 증가시킨 좌표가 N과 같다면 적은 제거한다.
		Iterator<Enemy> ite = copyEnemies.iterator();
		while (ite.hasNext()) {
			Enemy e = ite.next();
			e.r++;
			if (e.r == N) ite.remove();
		}
	}
	static Enemy findEnemy(List<Enemy> copyEnemies, int archer) {
		int minD = 1 << 30, minC = 50;
		Enemy find = null;
		for (Enemy e : copyEnemies) {
			int d = N - e.r + Math.abs(archer - e.c);
			if (d > D || d > minD) continue;
			
			// 새롭게 찾은 적과의 거리가 기존에 찾은 적과의 거리보다 적은 경우
			if (d < minD) {
				minD = d;
				minC = e.c;
				find = e;
				continue;
			}
			// 새롭게 찾은 적의 거리가 현재의 최소 거리와 같다.
			if (minC > e.c) {
				minC = e.c;
				find = e;
			}
		}
		return find;
	}
}