package studyyyy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7964 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int cnt = 1;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] == 0) {
					if (cnt == D) {
						ans++;
						cnt = 1;
					} else {
						cnt++;
					}
				} else {
					cnt = 1;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
