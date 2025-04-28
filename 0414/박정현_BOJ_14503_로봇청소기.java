import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박정현_BOJ_14503_로봇청소기 {

	static int N, M;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static boolean[][] visited;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (d == 1)
			d = 3;
		else if (d == 3)
			d = 1;

		dfs(r, c, d, false);

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					ans++;
			}
		}
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int d, boolean check) {
		visited[r][c] = true;

		for (int k = 0; k < 4; k++) {
			int nr = r + dr[(d+k)%4];
			int nc = c + dc[(d+k)%4];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			if (visited[nr][nc])
				continue;
			if (map[nr][nc] == 1)
				continue;

			dfs(nr, nc, (d+k)%4, false);
		}

		if (d == 0) {
			if (r + 1 >= N || map[r + 1][c] == 1)
				return;
			dfs(r + 1, c, d, check);
		} else if (d == 1) {
			if (c + 1 >= M || map[r][c + 1] == 1)
				return;
			dfs(r, c + 1, d, check);
		} else if (d == 2) {
			if (r - 1 < 0 || map[r - 1][c] == 1)
				return;
			dfs(r - 1, c, d, check);
		} else {
			if (c - 1 < 0 || map[r][c - 1] == 1)
				return;
			dfs(r, c - 1, d, check);
		}
	}
}
