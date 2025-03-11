import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1003_피보나치함수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			List<Integer[]> list = new ArrayList<>();
			list.add(new Integer[] {1, 0});
			list.add(new Integer[] {0, 1});
			for (int i = 2; i <= N; i++) {
				Integer n1 = list.get(i-1)[0] + list.get(i-2)[0];
				Integer n2 = list.get(i-1)[1] + list.get(i-2)[1];
				list.add(new Integer[] {n1, n2});
			}
			
			System.out.println(list.get(N)[0] + " " + list.get(N)[1]);
		}
	}
}
