import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1929_소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] isTrue = new boolean[N+1];
		Arrays.fill(isTrue, true);
		
		isTrue[0] = isTrue[1] = false;
		
		for (int i = 2; i*i <= N; i++) {
			if (isTrue[i] == true) {
				for (int j = i; j <= N; j+=i) {
					if (i != j && j % i == 0) {
						isTrue[j] = false;
					}
				}
			}
		}
		
		for (int i = M; i < N+1; i++) {
			if (isTrue[i]) System.out.println(i);
		}
	}
}
