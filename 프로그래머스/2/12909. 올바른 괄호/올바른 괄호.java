import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] text = s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < text.length; i++){
        
            if(text[i] == '('){
                stack.push('(');    
            }
            else{
                if(stack.size() > 0 && stack.peek() == '(' ){
                    stack.pop();
                }
                else{
                    answer = false;
                    break;
                }
            }
        }
        if(stack.size() > 0) answer= false;

        return answer;
    }
}