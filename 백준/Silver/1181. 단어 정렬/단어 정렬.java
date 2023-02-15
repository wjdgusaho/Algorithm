import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class compare implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		if (o1.length() == o2.length())
			return o1.compareTo(o2);
		else {
			return o1.length() - o2.length();
		}
	}
}
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		Set<String> strSet = new HashSet<>();
		
		for(int t = 0; t < T; t++) {
			strSet.add(br.readLine());	
		}
		
		List<String> list=new ArrayList<>();
		
		for (String str : strSet) {
			list.add(str);
		}
		
		Collections.sort(list, (o1, o2) -> {
			if(o1.length() == o2.length()) return o1.compareTo(o2);
			else return o1.length() - o2.length();
		});
		
		for(int t = 0; t < list.size(); t++) {
			System.out.println(list.get(t));
		}
	}
}