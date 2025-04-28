import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795_먹을것인가먹힐것인가 {
	
	static int[] arrA, arrB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			arrA = new int[N];
			arrB = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arrA);
			Arrays.sort(arrB);

			int ans = 0;
			for (int i = 0; i < arrA.length; i++) {
				int idx = binary(arrA[i]);
				ans += idx;
			}
			System.out.println(ans);
		}

	}

	private static int binary(int i) {
		int left = 0;
		int right = arrB.length;
		while (left < right) {
			int mid = (left+right)/2;
			if (arrB[mid] < i) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}

