import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ11000_강의실배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> times = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for (int j = s; j < e; j++) {
				times.put(j, times.getOrDefault(j, 0)+1);
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int s : times.values()) {
			max = Math.max(max, s);
		}
		
		System.out.println(max);
		
	}
}
