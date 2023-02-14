import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            int[] arr = new int[N];
             
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
             
            int max = -1;
            for(int i = 0; i < N-1; i++) {
                for(int j = i+1; j < N; j++) {
                    int tmp = arr[i]+arr[j];
                    if (tmp > max && tmp <= M) max = tmp;
                }
            }
            System.out.println("#"+(t+1)+" "+max);
        }
    }
}