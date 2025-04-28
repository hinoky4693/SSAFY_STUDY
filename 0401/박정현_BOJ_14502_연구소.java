import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박정현_BOJ_14502_연구소 {
	static int N, M, max;
	static int[][] map;
	static int[] sel;
	static List<int[]> list;
	static List<int[]> virus;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int count1 = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		sel = new int[3];
		list = new ArrayList<>();
		virus = new ArrayList<>();
		visited = new boolean[N][M];
		max = Integer.MIN_VALUE;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = st.nextToken().charAt(0) - '0';
				if (map[r][c] == 0)
					list.add(new int[] { r, c });
				else if (map[r][c] == 1)
					count1++;
				else if (map[r][c] == 2)
					virus.add(new int[] { r, c });
			}
		}
		comb(0, 0);
		System.out.println(max-count1-3);
	}

	private static void comb(int idx, int sidx) {
		if (sidx == 3) {
			map[list.get(sel[0])[0]][list.get(sel[0])[1]] = 1;
			map[list.get(sel[1])[0]][list.get(sel[1])[1]] = 1;
			map[list.get(sel[2])[0]][list.get(sel[2])[1]] = 1;

			visited = new boolean[N][M];
			for (int[] arr : virus) {
				bfs(arr[0], arr[1]);
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j])
						count++;
				}
				if (count > max)
					max = count;
			}
			map[list.get(sel[0])[0]][list.get(sel[0])[1]] = 0;
			map[list.get(sel[1])[0]][list.get(sel[1])[1]] = 0;
			map[list.get(sel[2])[0]][list.get(sel[2])[1]] = 0;
			return;
		}

		for (int i = idx; i < list.size(); i++) {
			sel[sidx] = i;
			comb(i + 1, sidx + 1);
		}
	}

	private static void bfs(int r, int c) {
		visited[r][c] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == 0) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
	}

}
