import java.util.*;
public class Main {
    static int N, M;
    static int[] inputs, numbers;
    static boolean[] visited;
    public static void main(String[] aregs){

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        inputs = new int[N];
        numbers = new int[M];
        visited = new boolean[N];

        for(int i = 1; i <= N; i++){
            inputs[i-1] = i;
        }

        perm(0);

    }

    public static void perm(int cnt){

        if(cnt == M){
            for(int i = 0; i < M; i++){
                 System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            numbers[cnt] = inputs[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}