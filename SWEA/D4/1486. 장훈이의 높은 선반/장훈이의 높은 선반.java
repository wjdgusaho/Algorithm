import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int N, B, map[], numbers[], ans, min;
     
    public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int tc = 1; tc <= TC; tc++) {
             
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
             
            map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ans = 0;
            min = Integer.MAX_VALUE;
             
            for(int i = 1; i <= N; i++) {
                numbers = new int[i];
                comb(0, 0, i);
            }
             
            ans = min;
            System.out.println("#"+tc+" "+ans);
        }
         
    }
     
    static void comb(int start, int cnt, int f){
         
        if(cnt == f) {
            //System.out.println(Arrays.toString(numbers));
            int sum = 0;
            for(int i = 0; i < f; i++) {
                sum += numbers[i];
            }
            if(sum >= B) {
                sum = sum - B;
                min = Math.min(sum, min);
                //System.out.println(Arrays.toString(numbers));
            }
            return;
        }
         
        for(int i = start; i < N; i++) {
            numbers[cnt] = map[i];
            comb(i+1, cnt+1, f);
        }
    }
     
}