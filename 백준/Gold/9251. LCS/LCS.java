import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr1 = br.readLine().split("");
		String[] arr2 = br.readLine().split("");
		
		int size1 = arr1.length;
		int size2 = arr2.length;
		int[][] map = new int[size1+1][size2+1];
		int maxLevel = 0;
		for(int i = 1; i < size1+1; i++) {
			for(int j = 1; j < size2+1; j++) {
				if(arr1[i-1].equals(arr2[j-1])) {
					map[i][j] = map[i-1][j-1] + 1;
					maxLevel = Math.max(map[i][j], maxLevel);
				}
				else {
					map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
				}
			}
		}
		
		System.out.println(maxLevel);
	}
}