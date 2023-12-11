import java.util.*;
import java.io.*;

public class Main extends IOException {

    static int N, cnt;
    static int[][] map;
    static List<Integer> result;
    static boolean[][] visited;
    public static void main(String[] arges) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        result = new ArrayList<Integer>();
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
           map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0) continue;
                if(visited[i][j]) continue;
                bfs(i, j);
                cnt++;
            }
        }

        System.out.println(cnt);
        Collections.sort(result);
        for(Integer num : result){
            System.out.println(num);
        }

    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    public static void bfs(int r, int c){
        Queue<int[]> que = new ArrayDeque<int[]>();
        que.offer(new int[] {r, c});
        visited[r][c] = true;
        int houseCnt = 1;

        while(!que.isEmpty()){
            int tmp[] = que.poll();
            for(int i = 0; i < 4; i++){
                int nr = tmp[0] + dr[i];
                int nc = tmp[1] + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                que.offer(new int[] {nr, nc});
               houseCnt++;
            }
        }
        result.add(houseCnt);
    }

}