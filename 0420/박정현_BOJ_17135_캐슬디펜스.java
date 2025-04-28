import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박정현_BOJ_17135_캐슬디펜스 {

	static int N, M, D;
	static int[][] map;
	static int[][] archers = { { 1, 1, 1, 0, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 },
			{ 1, 0, 1, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 1, 1, 1, 0 }, { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 1 },
			{ 0, 0, 1, 1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

	}
}
