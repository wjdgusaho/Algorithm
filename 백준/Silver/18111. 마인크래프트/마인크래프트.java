import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int maxHeight = 0;
        int minHeight = 256;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = -1;

        for (int h = minHeight; h <= maxHeight; h++) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int difference = map[i][j] - h;

                    if (difference > 0) { // 제거
                        time += difference * 2;
                        inventory += difference;
                    } else if (difference < 0) { // 추가
                        time -= difference; // -difference는 양수가 됨
                        inventory += difference; // 블록을 사용하므로 감소
                    }
                }
            }

            if (inventory >= 0 && time <= resultTime) {
                resultTime = time;
                resultHeight = h;
            }
        }

        System.out.println(resultTime + " " + resultHeight);
    }
}