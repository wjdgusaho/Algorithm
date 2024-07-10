import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        
        PriorityQueue pq = new PriorityQueue<Long>();
        for(int i = 0; i < scoville.length; i++){
            pq.offer((long)scoville[i]);
        }
        
        while(!pq.isEmpty()){
            //pq값에 1개만 있는데도 그값이 K보다 작으면 실패
            if(pq.size() == 1 && (long)pq.peek() < K){
                answer = -1;
                break;
            }
            long a = (long)pq.poll();
            //한개가 아닌 상태에서 제일 작은값이 K보다 크면 끝내야지!
            if(a >= K)break;
            long b = (long)pq.poll();
            long tmp = a + (b * 2);
            pq.offer(tmp);
            answer++;
        }
        
        
        return answer;
    }
}