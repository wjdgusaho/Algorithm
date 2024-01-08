import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> dp = new ArrayList<>();
		dp.add(0);
		dp.add(1);
		dp.add(3);
		for(int i = 3; i <= N; i++) {
			int tmp = dp.get(i-1) + dp.get(i-2)*2;
			dp.add(tmp %10007);
		}
		System.out.println(dp.get(N));
	}
}