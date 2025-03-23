import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박정현_백준_1182_부분수열의합 {
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			int[] sel = new int[i];
			comb(0, 0, nums, sel, S);
		}
		System.out.println(ans);

	}

	private static void comb(int idx, int sidx, int[] nums, int[] sel, int S) {
		if (sidx == sel.length) {
			int sum = 0;
			for(int i : sel) {
				sum += i;
			}
			if (sum == S) {
//				System.out.println(sum + " ::: " + S);
//				System.out.println(Arrays.toString(sel));
				ans++;
			}
			return;
		}

		for (int i = idx; i <= nums.length - sel.length + sidx; i++) {
			sel[sidx] = nums[i];
			comb(i + 1, sidx + 1, nums, sel, S);
		}
	}
}
