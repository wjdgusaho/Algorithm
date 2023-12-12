class Solution {
    // t초 동안 붕대를 감으면 1초마다 x만큼 회복
    // t초 연속으로 붕대를 감는데 성공시 y만크 추가 회복
    // 최대 최력 존재
    // 공격 받으면 기술 취소 -> 즉시 다시 붕대 감고 0초부터 시작
    // 공긱 받으면 체력(-) 0이하 죽음
    // 생존가능한가?  0 이하시 -1
    
    // bandage 시전시간, 초당회복량, 추가회복량
    // attaks 공격시간 , 피해량
    // health 최대체력
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int attackSize = attacks.length;
        int idx = 0;
        int time = 0;
        int cnt = 0; //연속
        int heart = health;
        
        while(idx < attackSize){
            time++;
        
            if(attacks[idx][0] == time){
                cnt = 0;
                heart -= attacks[idx][1];
                idx++;
            }
            else{
                cnt++;
                if(heart <= health){
                    heart += bandage[1];
                    if(cnt == bandage[0]){
                        heart += bandage[2];
                        cnt = 0;
                    }
                }else{
                    cnt = 0;  
                } 
            } 
            if(heart > health) heart = health;
            //System.out.println(time + " " + heart + " " + cnt);
            if(heart <= 0)break;   
        }
        
        return heart <= 0 ? -1 : heart;
    }
}