import java.util.*;
class Solution {
    static public int aCnt = 1;
    static public int cCnt = 0;
    static public int bCnt = 0;
    static public int[] cValue = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
    static public int[] bValue = {2, 1, 2, 3, 2, 4, 2, 5};
    
    public int[] solution(int[] answers) {
       
        
        int[] trueCnt =  {0,0,0};
        
        int aTrue = 0;
        int bTrue = 0;
        int cTrue = 0;
        
        for(int i = 0; i < answers.length; i++){
            //1번 1 2 3 4 5 반복
            if(aCheck(answers[i])) trueCnt[0]++;
            //2번 2 1 2 3 2 4 2 5 반복
            if(bCheck(answers[i])) trueCnt[1]++;
            //3번 3 3 1 1 2 2 4 4 5 5 반복
            if(cCheck(answers[i])) trueCnt[2]++;
        }
        
        int maxCnt = 0;
        int maxIndexCnt = 0;
        for(int i = 0; i < trueCnt.length; i++){
            if(maxCnt < trueCnt[i]) {
                maxCnt = trueCnt[i];
                maxIndexCnt = 1;
            }else if(maxCnt == trueCnt[i]){
                maxIndexCnt++;
            }
        }
      
        int[] answer = new int[maxIndexCnt];
        int index = 0;
        for(int i = 0; i < trueCnt.length; i++){
            if(maxCnt == trueCnt[i]){
                answer[index++] = i+1;
            }
        }
        
        return answer;
    }
    

    public boolean aCheck(int answer){
        if(aCnt > 5) aCnt = 1;
        if(answer == aCnt++) return true;
        return false;
    } 
    
   
    public boolean bCheck(int answer){
        if(bCnt + 1 > bValue.length) bCnt = 0;
         if(bValue[bCnt++] == answer) return true;
         return false;
    } 
    
     
     public boolean cCheck(int answer){
        if(cCnt + 1 > cValue.length) cCnt = 0;
        if(cValue[cCnt++] == answer) return true;
         return false;
    } 
}