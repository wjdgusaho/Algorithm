import java.util.*;
class Solution {
    
    public static int[] input, number;
    public static boolean[] visited;
    public static int N;
    public static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
       
        
        N = dungeons.length;
        input = new int[N];
        visited = new boolean[N];
        number = new int[N];
        for(int i = 0; i < N; i++){
            input[i] = i;
        }
        
      
        
        comb(0, dungeons, k);
        return answer;
    }
    
    public void comb(int cnt, int[][] dungeons, int k){
        if(cnt == N){
            //System.out.println(Arrays.toString(number));
            check(dungeons, k);
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            number[cnt] = input[i];
            comb(cnt+1, dungeons, k);
            visited[i] = false;
        }
    }
    
    public void check(int[][] dungeons, int k){
        int tmpK = k;
        int dungenCnt = 0;
        for(int i = 0; i < N; i++){
            int index = number[i];
            
            if(tmpK >= dungeons[index][0]){
                tmpK -= dungeons[index][1];
                dungenCnt++;
            }   
        }
        answer = Math.max(answer, dungenCnt);
    }
}