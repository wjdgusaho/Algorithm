import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> onePq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> twoPq = new PriorityQueue<Integer>();
        
        int pollCnt = 0; 
        int dataIs = 1;
        for(int i = 0; i < operations.length; i++){
            String[] tmp = operations[i].split(" ");
            if(tmp[0].equals("I")){
                if(dataIs == 1){
                    onePq.offer(Integer.valueOf(tmp[1]));
                }else{
                    twoPq.offer(Integer.valueOf(tmp[1]));
                }
            }
            else{
                if(Integer.valueOf(tmp[1]) == 1){
                    //최대값 삭제
                    if(dataIs == 1){
                        dataIs = 2;  //데이터 위치 변경될거니깐
                        int pqSize = onePq.size();
                        for(int j = 0; j < pqSize; j++){
                            if(j == pqSize - 1) onePq.poll();
                            else twoPq.offer(onePq.poll());
                        }
                    }else{
                        dataIs = 1;
                        int pqSize = twoPq.size();
                        for(int j = 0; j < pqSize; j++){
                            if( j == pqSize - 1 ) twoPq.poll();
                            else onePq.offer(twoPq.poll());
                        }
                    }
                }
                else{
                    //최소값 걍 현재 맨앞값 빼주면됨
                     if(dataIs == 1) onePq.poll();
                     else twoPq.poll();
                }
            }
        }
        if(dataIs == 1 && onePq.size() != 0){
            int pqSize = onePq.size();
            for(int j = 0; j < pqSize; j++){
                int tmp = onePq.poll();
                if(j == 0 ) answer[1] = tmp; 
                if(j == pqSize - 1) answer[0] = tmp;
            }
        }else if(dataIs == 2 && twoPq.size() != 0) {
            int pqSize = twoPq.size();
            for(int j = 0; j < pqSize; j++){
                int tmp = twoPq.poll();
                if(j == 0 ) answer[1] = tmp; 
                if(j == pqSize - 1) answer[0] = tmp;
            }
        }else{
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}