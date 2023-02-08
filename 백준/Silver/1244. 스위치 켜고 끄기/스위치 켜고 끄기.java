import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int num;	
	static int[] state;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 남학생은 스위치의 배수의 값번호의 상태를 바꾸고
		// 여학생은 자신의 번호의 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을
		// 에속한 스위치를 모두 바꾼다. 모두 대칭이 아니면 뽑힌번호의 상태만

		// 남학생 1 여행생 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		num = Integer.parseInt(br.readLine());

		state = new int[num + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < num + 1; i++) {
			state[i] = Integer.parseInt(st.nextToken());
		}

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] tmp = br.readLine().split(" ");

			switchs(tmp, 0);

		}

		int cnt = 1;
		for (int i = 1; i < num + 1; i++) {
			bw.write(state[i] + " ");
			cnt += 1;
			if (cnt == 21) {
				bw.write("\n");
				cnt = 1;
			}
		}
		bw.close();

	}

	private static void switchs(String[] tmp, int cnt) {

		String Gender = tmp[0];
		int numbers = Integer.parseInt(tmp[1]);

		if (Gender.equals("1")) {

			for (int i = numbers; i < num + 1; i += numbers) {

				state[i] = (state[i] == 0 ? 1 : 0);

			}
		}

		if (Gender.equals("2")) {

			int idx = 1;
			int check = numbers;
			//int right = numbers + 1;
			//int left = numbers - 1;
			
			while (check - idx >= 1 && check + idx <= num) {
				if (state[check - idx] == state[check + idx]) {
					idx += 1;
					continue;
				}
				break;
			}
			idx -= 1;
			if (idx == 0)
				state[numbers] = (state[numbers] == 0 ? 1 : 0);
			else {
				for (int i = check - idx; i <= check + idx; i++) {
					if (state[i] == 0)
						state[i] = 1;
					else
						state[i] = 0;
					
				}
			}
		}
	}
}
