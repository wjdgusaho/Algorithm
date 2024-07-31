import java.util.*;
class Solution {
    
    public int N;
    public int check[];
    public int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        N = numbers.length;
        check = new int[N];
        subset(0, numbers, target);
    
        return answer;
    }
    
    public void subset(int cnt, int[] numbers, int target){
        if(N == cnt){
            int sum = 0;
            for(int i = 0; i < N; i++){
               sum += numbers[i] * check[i];
            }
            if(sum == target){
                answer++;
            } 
            return;
        }
        
        
        check[cnt] = -1;
        subset(cnt + 1, numbers, target );
        check[cnt] = 1;
        subset(cnt + 1, numbers, target);
        
    }
}