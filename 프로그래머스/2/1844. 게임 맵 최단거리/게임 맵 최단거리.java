import java.util.*;
class Solution {
    
    public int N, M, answer;
    public boolean[][] visited;
    public int solution(int[][] maps) {
        answer = -1;
        
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        bfs(maps);
        
        return answer;
    }
    
    public void bfs(int[][] maps){
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Deque<int[]> que = new ArrayDeque<int[]>();
        que.offer(new int[] {N-1, M-1} );
        visited[N-1][M-1] = true;
        int level = 0;
        
        while(!que.isEmpty()){     
            level++;
            int size = que.size();
            for(int s = 0; s < size; s++){
                int[] tmp = que.poll();
                if(tmp[0] == 0 && tmp[1] == 0){
                    answer = level;
                    return;
                }
                for(int i = 0; i < 4; i++){
                    int nr = tmp[0] + dr[i];
                    int nc = tmp[1] + dc[i];
                  
                    if(nr < 0 || nr >= N || nc < 0 || nc >=M) continue;
                    if(visited[nr][nc]) continue;
                    if(maps[nr][nc] == 0) continue;
                    visited[nr][nc] = true;
                    //System.out.println("nr : " + nr + " nc : "+ nc + " level : " + level);
                    que.offer(new int[] {nr, nc});
                }
            } 
        }
    }
}