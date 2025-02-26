package studyyyy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA6485 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] bus = new int[N][2];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					bus[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int P = Integer.parseInt(br.readLine());

			StringBuilder sb = new StringBuilder();
			int ans = 0;
			for (int i = 0; i < P; i++) {
				ans = 0;
				int c = Integer.parseInt(br.readLine());
				for (int j = 0; j < N; j++) {
					if (c >= bus[j][0] && c <= bus[j][1]) {
						ans++;
					}
				}
				sb.append(" " + ans);
			}
			
			System.out.println("#" + tc + sb);

		}
	}
}
