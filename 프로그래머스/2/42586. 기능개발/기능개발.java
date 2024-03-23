import java.util.*;
class Solution {
    
    public static class Data {
        int progress;
        int speed;
        int index;
        
        public Data(int progress, int speed, int index){
            this.progress = progress;
            this.speed = speed;
            this.index = index;
        } 
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue que = new ArrayDeque<Data>();
        int proSize = progresses.length;
        for(int i = 0; i < proSize; i++){
            que.offer(new Data(progresses[i], speeds[i], i));
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] check = new boolean[proSize];
        //현재 point
        int point = 0;
        
        while(!que.isEmpty()){
            int queSize = que.size();
            
            for(int s = 0; s < queSize; s++){
                Data tmp = (Data) que.poll();
                if(tmp.progress >= 100){
                    check[tmp.index] = true;
                }
                else{
                    int nextProgress = tmp.progress + tmp.speed;
                    que.offer(new Data(nextProgress, tmp.speed, tmp.index));
                }
            }
            int endCnt = 0;
            for(int p = point; p < proSize; p++){
                if(check[p])endCnt++;
                else break;
            }
            if(endCnt > 0){
                list.add(endCnt);
                point += endCnt;
            } 
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;   
    }
}