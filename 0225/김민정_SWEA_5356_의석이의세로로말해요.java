package studyyyy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA5356 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int maxLen = -1;
			char[][] arr = new char[5][];
			for (int i = 0; i < 5; i++) {
				arr[i] = br.readLine().toCharArray();
				maxLen = Math.max(maxLen, arr[i].length);
			}

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < maxLen; i++) {
				for (int j = 0; j < 5; j++) {
					if (i > arr[j].length - 1)
						continue;
					sb.append(arr[j][i]);
				}
			}

			System.out.println("#" + tc + " " + sb);
		}
	}
}
