import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1182_부분수열의합_비트마스킹 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		
		int cnt = 0;
		for (int i = 1; i < (1<<N); i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1<<j)) != 0) {
					sum += nums[j];
					if (i == 30) {
						System.out.println("ss " + sum + nums[j]);
					}
					if (sum >= S) break;
				}
			}
			if (sum == S) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
