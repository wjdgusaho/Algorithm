class Solution {
    public int solution(String s) {
        
        String[] numStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; 
        int answer = 0;
        
        int n = 9;
		for(int i = 0; i <= n; i++ ) {
            if(s.contains(numStr[i])){
			    s = s.replaceAll(numStr[i], i+"");
            }
        } 
        answer = Integer.parseInt(s);
        return answer;
        
    }
}