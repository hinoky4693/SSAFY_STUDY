import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 박정현_BOJ_10026_적록색약 {
	static int N;
	static char[][] map, map2;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited, visited2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		System.out.println(count);
		// 정상인 dfs

		visited2 = new boolean[N][N];
		map2 = map.clone();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map2[i][j] == 'G') {
					map2[i][j] = 'R';
				}
			}
		}

		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited2[i][j]) {
					dfs2(i, j);
					count++;
				}
			}
		}
		System.out.println(count);
		// 색약 dfs
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == map[r][c]) {
				dfs(nr, nc);
			}
		}
	}

	private static void dfs2(int r, int c) {
		visited2[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited2[nr][nc] && map2[nr][nc] == map2[r][c]) {
				dfs2(nr, nc);
			}
		}
	}

}
