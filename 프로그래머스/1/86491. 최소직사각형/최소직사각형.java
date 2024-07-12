import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        //제일 큰값과 제일 작은값 찾기
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < sizes.length; i++){
            for(int j = 0; j < sizes[i].length; j++){
                maxValue = Math.max(maxValue, sizes[i][j]);
                minValue = Math.min(minValue, sizes[i][j]);
            }
        }
        
        //비교 해서 값 변경 (가장 큰값은 변경될일 없음, 작은값이 변경됨)
        for(int i = 0; i < sizes.length; i++){
            int minTmp = 0;
            
            if(sizes[i][0] > sizes[i][1]){
                minTmp = sizes[i][1];
            }else{
                minTmp = sizes[i][0];
            }
            
            //기존 값이랑 비교
            minValue = Math.max(minValue, minTmp);
        }
        
        return minValue*maxValue;
    }
}