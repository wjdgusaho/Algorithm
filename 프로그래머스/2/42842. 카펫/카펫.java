class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];       
        
  
        //yellow 짝수는 몇줄인지 체크해야함
  
            int yellowLine = 1;
            int tmp = 0;
            while(true){
                tmp = brown-4-(yellowLine*2);
                int a = yellow/yellowLine;
                int aCheck = yellow%yellowLine;
                int b = tmp/2;
                int bCheck = tmp%2;
                if(a == b && aCheck == 0 && bCheck == 0) {
                    break;
                }
                yellowLine++;
            }
            //양끝에 더해줘야함
            answer[0] = tmp/2 +2;
            //yellow라인의 brown 위아래 라인 더해줘야함
            answer[1] = yellowLine + 2;
      
        
        return answer;
    }
}