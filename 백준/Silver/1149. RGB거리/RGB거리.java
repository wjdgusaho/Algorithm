import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.InputMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] memori = new int[N];

		for (int n = 0; n < N; n++) {
			int[] min = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] idx = new int[3];
			if (n == 0) {
				for (int i = 0; i < 3; i++) {
					memori[i] = min[i];
					idx[i] = i;
				}
				continue;
			} else {
				int[] tmp = new int[3];
				for (int i = 0; i < 3; i++) {
					tmp[i] = Integer.MAX_VALUE;
				}

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (i == j)
							continue;
						tmp[j] = Math.min(tmp[j], memori[i] + min[j]);
					}
				}
				memori = tmp;
			}
		}
//		System.out.println(Arrays.toString(memori));

		int anw = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			anw = Math.min(anw, memori[i]);
		}
		System.out.println(anw);
	}

}