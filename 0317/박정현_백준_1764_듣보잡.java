import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 박정현_백준_1764_듣보잡 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			map.put(temp, temp);
		}
		
		List<String> ans = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			String data = map.get(br.readLine());
			if (data != null) {
				ans.add(data);
			}
		}
		
		System.out.println(ans.size());
		
		Collections.sort(ans);
		
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
		
		
	}
}
