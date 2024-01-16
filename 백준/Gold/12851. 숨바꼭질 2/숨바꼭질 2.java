import java.util.*;
import java.io.*;

public class Main {
    
    public static int N, K;
    public static int cnt, time;
    public static boolean[] visited;
    public static boolean check;
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[1000010];

        bfs();
        System.out.println(time-1);
        System.out.println(cnt);
    }

    public static void bfs(){
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(N);
        visited[N] = true;
        check = true;
        time = 0;
        while(!que.isEmpty() && check){
            int size = que.size();
            for(int s = 0; s < size; s++){
                int tmp = que.poll();
                visited[tmp] = true;
                if(tmp == K){ 
                    cnt++;
                    check = false;
                }

                int[] next = new int[] {tmp-1, tmp+1, tmp*2};
            
                for(int i = 0; i < next.length; i++){
                    if(next[i] >= 0 && next[i] <= 100000 && !visited[next[i]]){
                        que.offer(next[i]);
                    }
                    else{
                        if(next[i] == K) que.offer(next[i]);
                    }
                }    
            }
            time++;
        }
    }

}