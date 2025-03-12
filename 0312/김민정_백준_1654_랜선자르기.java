import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654_랜선자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		long ans = -1;
		
		long left = 1;
		long right = Integer.MAX_VALUE;
		
		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;
			for (int i = 0; i < K; i++) {
				cnt += arr[i] / mid;
			}
			
			if (cnt < N) {
				right = mid - 1;
			} else {
				ans = Math.max(ans, mid);
				left = mid + 1;
			}
		}
		
		System.out.println(ans);
	}
}
