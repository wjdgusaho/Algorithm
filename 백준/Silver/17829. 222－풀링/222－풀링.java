import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N, map[][], ans;
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++)map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
       
        ans = 0;
        sizeCut(N, map);
        
        System.out.println(ans);
    }
    
	private static void sizeCut(int size, int[][]maps) {
		/*
		System.out.println("==="+ size +"=============");
		for(int i = 0; i < size; i++) {
        	for(int j = 0; j < size; j++) {
        		System.out.print(maps[i][j] +" ");
        	}
        	System.out.println();
		}
		*/
		
		if(size == 2) {
			int idx = 0;
			int[] tmp = new int[size*2];
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					//System.out.println(idx);
					//System.out.print(maps[i][j] + " ");
				  	tmp[idx++] = maps[i][j];
				}
				//System.out.println();
			}
			Arrays.sort(tmp);
			ans =tmp[2];
			return;
		}
		
		int[][] newMap = new int[size/2][size/2];
		
		int r = 0;
		int c = 0;
		
		for(int i = 0; i < size; i+=2) {
        	for(int j = 0; j < size; j+=2) {
        		//System.out.println(r + " " + c);
        		int[] tmp = new int[4];
        		tmp[0] = maps[i][j];
        		tmp[1] = maps[i][j+1];
        		tmp[2] = maps[i+1][j];
        		tmp[3] = maps[i+1][j+1];
        		Arrays.sort(tmp);
        		newMap[r][c] = tmp[2];
        		c++;
        	}
        	r++;
        	c = 0;
        }
		sizeCut(size/2 , newMap);
	}

    /*
    static void cut(int r, int c, int size) {

        if(size == 2) {
        }
        else {
            int arr[] = new int[4];
            size = size/2;

            arr[0] = cut(r, c, size);
            arr[1] = cut(r, c+size, size);
            arr[2] = cut(r+size, c , size);
            arr[3] = cut(r+size, c+size + size);
        }
    }
	*/
}