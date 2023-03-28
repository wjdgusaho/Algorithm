import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] memori = new int[n][3]; // 각 집을 칠할 때 최소 비용을 저장하는 배열

        // 첫번째 집을 칠할 때 비용 입력
        int[] min = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        memori[0][0] = min[0];
        memori[0][1] = min[1];
        memori[0][2] = min[2];

        for (int i = 1; i < n; i++) {
            // 현재 집을 빨간색으로 칠했을 때의 최소 비용
            min = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            memori[i][0] = Math.min(memori[i-1][1], memori[i-1][2]) + min[0];
            // 현재 집을 초록색으로 칠했을 때의 최소 비용
            memori[i][1] = Math.min(memori[i-1][0], memori[i-1][2]) + min[1];
            // 현재 집을 파란색으로 칠했을 때의 최소 비용
            memori[i][2] = Math.min(memori[i-1][0], memori[i-1][1]) + min[2];
        }

        // 마지막 집을 각각 빨간색, 초록색, 파란색으로 칠했을 때의 비용 중 최소값을 출력
        int anw = Math.min(memori[n-1][0], Math.min(memori[n-1][1], memori[n-1][2]));
        System.out.println(anw);
    }
}