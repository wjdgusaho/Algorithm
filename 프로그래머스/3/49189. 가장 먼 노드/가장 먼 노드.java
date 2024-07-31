import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        int[] count = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        List[] list = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        //양방향이니깐(입력)
        for(int i = 0; i < edge.length; i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
    
        Deque<Integer> que = new ArrayDeque<>();
        que.offer(1);
        visited[1] = true;
        count[1] = 0;
        int level = 1;
        
        while(!que.isEmpty()){
            int size = que.size();
            for(int s = 0; s < size; s++){
                int idx = que.poll();
                count[idx] = level;
                List<Integer> tmpList = list[idx];
                for(int tmp : tmpList){
                    if(visited[tmp]) continue;
                    visited[tmp] = true;
                    que.offer(tmp);
                }
            }
            level++;
        }
        
        int maxValue = 0;
        int maxCnt = 0;
        for(int i = 1; i <= n; i++){
            if(maxValue < count[i]){
                maxValue = count[i];
                maxCnt = 1;
            }else if( maxValue == count[i]) maxCnt++;
            else continue;
        }
        return maxCnt;
    }
}