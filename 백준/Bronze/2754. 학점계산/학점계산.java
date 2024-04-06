import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        double result = 0;  //학점
        char tmp = s.charAt(0);
        if (tmp == 'A') {
            result = 4;
        } else if (tmp == 'B') {
            result = 3;
        } else if (tmp == 'C') {
            result = 2;
        } else if (tmp == 'D') {
            result = 1;
        } else {
            System.out.print("0.0");
            return;
        }
        tmp = s.charAt(1);
        if (tmp == '+') {
            result += 0.3;
        } else if (tmp == '-') {
            result -= 0.3;
        }
        System.out.print(result);
    }
}