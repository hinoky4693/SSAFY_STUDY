import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박정현_BOJ_1072_게임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = b * 100 / a;
		long d = a - b;

		if (a == b) {
			System.out.println(-1);
			return;
		}
		
		long left = b;
		long right = 1010000000;
		long ans = 0;
		while (left < right) {
			long mid = (left + right) / 2;

			if ((mid - d) * 100 / mid == c) {
				while((mid - d) * 100 / mid == c) {
					ans = ++mid;
				}
				break;
			} else if ((mid - d) * 100 / mid > c) {
				right = mid - 1;
			} else if ((mid - d) * 100 / mid < c) {
				left = mid + 1;
			}
		}
		System.out.println(ans - a);
	}
}
