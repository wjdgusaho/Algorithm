import java.util.*;

class Solution {
    public int solution(int[] nums) {

        Set<Integer> number = new HashSet<Integer>();
        int N = nums.length / 2;
        for(int i : nums){
            number.add(i);
        }
        
        return Math.min(number.size(), N);
    }
}