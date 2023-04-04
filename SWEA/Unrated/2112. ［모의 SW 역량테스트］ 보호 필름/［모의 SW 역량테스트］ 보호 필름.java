import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Character.Subset;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] number;
	static int D, W, K, casAnswer, Min;
	static int[][] map;
	static int[][] copyMap;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[D][W];
			Min = Integer.MAX_VALUE;
			copyMap = new int[D][W];
			for (int i = 0; i < D; i++)
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			// for(int i = 0; i < D; i++) System.out.println(Arrays.toString(map[i]));

			boolean fin = false;
			for (int i = 0; i < D; i++) {
				number = new int[i];
				if (i == K) {
					fin = true;
					break;
				}
				if (comb(0, 0, i))
					break;
			}
			if (fin)
				System.out.println("#" + t + " " + K);
			else
				System.out.println("#" + t + " " + number.length);
		}
	}

	private static boolean comb(int cnt, int start, int f) {
		if (cnt == f) {
			if (f >= 1) {
				numAB = new int[f];
				if (permAB(0, f))
					return true;
			} else {
				for (int i = 0; i < D; i++)
					copyMap[i] = map[i].clone();
				if (CrushCheck()) {
					Min = Math.min(cnt, Min);
					return true;
				}
			}
			return false;
		}

		if (cnt >= Min) {
			return true;
		}

		for (int i = start; i < D; i++) {
			number[cnt] = i;
			if (comb(cnt + 1, i + 1, f))
				return true;

		}
		return false;
	}

	static int[] numAB;

	private static boolean permAB(int cnt, int f) {
		if (cnt == f) {
			// System.out.print(Arrays.toString(number) + " ");
			// System.out.println(Arrays.toString(numAB) +" ");
			// System.out.println("-------------------------------");

			for (int i = 0; i < D; i++)
				copyMap[i] = map[i].clone();

			int idx = 0;
			for (int i = 0; i < numAB.length; i++) {
				for (int c = 0; c < W; c++) {
					copyMap[number[idx]][c] = numAB[i];
				}
				idx++;
			}

			// for(int i = 0; i < D; i++) System.out.println(Arrays.toString(copyMap[i]));

			if (CrushCheck())
				return true;
			return false;
		}

		for (int i = 0; i < 2; i++) {
			numAB[cnt] = i;
			if (permAB(cnt + 1, f))
				return true;
		}
		return false;

	}

	private static boolean CrushCheck() {
		int[] check = new int[W];
		for (int c = 0; c < W; c++) {
			int maxCnt = 0;
			int sameCnt = 1;
			for (int r = 0; r < D - 1; r++) {
				// 전과 같다면
				if (copyMap[r][c] == copyMap[r + 1][c]) {
					sameCnt++;
				}
				// 같지 않다면
				else {
					sameCnt = 1;
				}
				maxCnt = Math.max(maxCnt, sameCnt);
				check[c] = maxCnt;
				if (K == maxCnt)
					break;

			}
			if (check[c] < K)
				return false;
		}
		// System.out.println("-------------------------------");
		// System.out.println(Arrays.toString(check));
		// System.out.println("===============================");
		// 같으면 이번 케이스는 성공이야 true/ 그게 아니면 false
		return true;
	}
}