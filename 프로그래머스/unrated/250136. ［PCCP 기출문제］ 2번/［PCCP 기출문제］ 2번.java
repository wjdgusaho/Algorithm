import java.util.*;

class Solution {
    
    int xsize;
    int ysize;
    int[][] tmp;
    Map<Integer, Integer> countMap;
    public int solution(int[][] land) {
        
        xsize = land.length;
        ysize = land[0].length;
        int maxCnt = 0;
        int indexCnt = 0;
        tmp = new int[xsize][ysize];
        countMap = new HashMap<Integer, Integer>();
        
        for(int j = 0; j < ysize; j++){  
          
           for(int i = 0; i < xsize; i++){
                int outCnt = 0;
               // 석유를 발견했다면 bfs 실행 단 indexCnt가없다면
               if(land[i][j] == 1 && tmp[i][j] == 0){
                  indexCnt++;
                  outCnt = bfs(i, j, land, indexCnt); 
                  countMap.put(indexCnt, outCnt);
               }
              
           }
       
        }
        
  
        for(int j = 0; j < ysize; j++){
            Set<Integer> hashset = new HashSet<Integer>();
            int checkCnt = 0;
            for(int i = 0; i < xsize; i++){
                if(tmp[i][j] != 0){
                    hashset.add(tmp[i][j]);
                }
            }
            Iterator<Integer> setIter = hashset.iterator();
            while(setIter.hasNext()){
              checkCnt += countMap.get(setIter.next());   
            }
            if( maxCnt <= checkCnt){
                maxCnt = checkCnt;
            }
        }
        
        
        return maxCnt;
    }
    
    
    
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    public int bfs(int x, int y, int[][] defaultint, int indexCnt){
     
        Queue<int[]> que = new LinkedList<int[]>();
        que.offer(new int[] {x, y});
        int cnt = 0;
        
        while(!que.isEmpty()){
            int[] a = que.poll();
            if(tmp[a[0]][a[1]] != 0) continue;
            tmp[a[0]][a[1]] = indexCnt;
            cnt+=1;
            for(int i = 0; i < 4; i++){
                
                int nr = a[0] + dr[i];
                int nc = a[1] + dc[i];
                
                //범위 벗어날 경우 예외처리 
                if(nr < 0 || nr >= xsize || nc < 0 || nc >= ysize)continue;
                if(defaultint[nr][nc] != 1) continue;
                //기름이 있다면.
                que.offer(new int[] {nr, nc});
            }
        }
        return cnt;
    }
}