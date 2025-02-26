package studyyyy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int velocity = 0;
			int distance = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				if (command == 1) {
					int d = Integer.parseInt(st.nextToken());
					velocity += d;
				} else if (command == 2) {
					int d = Integer.parseInt(st.nextToken());
					if (velocity > d) { // 속도가 음수 -> 0 m/s
						velocity -= d;
					} else {
						velocity = 0;
					}
				}
				distance += velocity;

			}

			System.out.println("#" + tc + " " + distance);
		}
	}
}
