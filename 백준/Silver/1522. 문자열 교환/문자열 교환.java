import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)  throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int size = arr.length;
        char[] addArr = new char[size+size];
        int aCnt = 0;
        

        for(int i = 0; i < size; i++){
            addArr[i] = arr[i];
            addArr[i+size] = arr[i];
            if(arr[i] == 'a') aCnt++;
        }
        
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < size; i++){
            int bCnt = 0;
            for(int j = 0; j < aCnt; j++){
                if(addArr[i+j] == 'b') bCnt++;        
            }
            result = Math.min(result, bCnt);
        }

        System.out.println(result);
    }

}