import java.util.*;
import java.io.*;

public class Main extends IOException{
    
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] arges) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int level = bfs();
        System.out.println(level);
    }

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int bfs(){
        
        Queue<int[]> que = new ArrayDeque<int[]>();
        que.offer(new int[] {0, 0});
        int level = 1;
        
        whileout:
        while(!que.isEmpty()){
            int size = que.size();
            for(int lev = 0; lev < size; lev++){
                int[] tmp = que.poll();
                if(tmp[0] == N-1 && tmp[1] == M-1) break whileout;
                for(int i = 0 ; i < 4; i++){
                    int nr = tmp[0] + dr[i];
                    int nc = tmp[1] + dc[i];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if(visited[nr][nc]) continue;
                    if(map[nr][nc] == 0) continue;
                    visited[nr][nc] = true;
                    que.offer(new int[]{nr, nc});
                
                }
            }
            level++;
        }

        return level;
    }
}