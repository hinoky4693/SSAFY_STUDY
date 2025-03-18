import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> names = new HashMap<>();
		TreeSet<String> dupli = new TreeSet<>();
		
		for (int i = 0; i < N; i++) {
			names.put(br.readLine(), 0);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if (names.containsKey(input)) {
				dupli.add(input);
			}
		}
		
		System.out.println(dupli.size());
		for (String str : dupli) {
			sb.append(str + "\n");
		}
		System.out.println(sb);
	}
}


