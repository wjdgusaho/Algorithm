import java.util.*;
import java.io.*;

public class Main {
	
	public static char[][] graph;
	public static StringBuffer sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		graph = new char[26][3];
		//입력
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char node = st.nextToken().charAt(0);
			graph[node-65][0] = node;
			for(int i = 1; i < 3; i++ ) {
				graph[node-65][i] = st.nextToken().charAt(0);
			}
		}
		
		sb = new StringBuffer();
		
		//전위
		preOrder(graph[0]);
		sb.append("\n");
		//중위
		inOrder(graph[0]);
		sb.append("\n");
		//후위
		postOrder(graph[0]);
		
		System.out.println(sb);
		
	}
	
	public static void preOrder(char[] tmp) {
		//루트 -> 왼쪽 -> 오른쪽
		sb.append(tmp[0]);
		if(tmp[1] != '.') preOrder(graph[tmp[1] - 65]);
		if(tmp[2] != '.') preOrder(graph[tmp[2] - 65]);
	}
	
	public static void inOrder(char[] tmp) {
		//왼쪽 -> 루트 -> 오른쪽
		if(tmp[1] != '.') inOrder(graph[tmp[1] - 65]);
		sb.append(tmp[0]);
		if(tmp[2] != '.') inOrder(graph[tmp[2] - 65]);
	}
	
	public static void postOrder(char[] tmp) {
		//왼쪽 - > 오른쪽 -> 루트
		if(tmp[1] != '.') postOrder(graph[tmp[1] - 65]);
		if(tmp[2] != '.') postOrder(graph[tmp[2] - 65]);
		sb.append(tmp[0]);
	}

}