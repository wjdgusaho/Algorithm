import java.util.*;
import java.io.*;



class Solution {
    
   public class Data {
        int progress;
        int speed;
    
        public Data(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> list = new ArrayList<>();

        Deque<Data> que = new ArrayDeque<Data>();
        for(int i = 0; i < progresses.length; i++){
            que.offer(new Data(progresses[i], speeds[i]));
        }
        
        while(!que.isEmpty()){
            int size = que.size();
            boolean check = true;
            int finCnt = 0;
            for(int s = 0; s < size; s++){
                Data tmp = (Data) que.poll();
                if(tmp.progress >= 100 && check){
                    finCnt++;
                }
                else{
                    check = false;
                    que.offer(new Data(tmp.progress + tmp.speed, tmp.speed));
                }
            }
            if(finCnt > 0){
                list.add(finCnt);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}