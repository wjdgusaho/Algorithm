import java.util.*;

class Solution {

    public String solution(int[] numbers) {
        String result="";
        
        String[] tmp = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            tmp[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(tmp, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        int check = 0;
         for(int i = 0; i < tmp.length; i++){
           result += tmp[i];
            check += Integer.valueOf(tmp[i]);
         }
        
        if(check == 0){
            result ="0";
        }
        
        return result;
    }   
}