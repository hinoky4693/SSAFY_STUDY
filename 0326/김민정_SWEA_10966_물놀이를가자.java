import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA10966_물놀이를가자 {

	static char[][] map;
	static boolean[][] visited;
	static int N, M, cnt, sum;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static Queue<int[]> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == 'W') {
						q.add(new int[] { i, j });
					}
				}
			}

			sum = 0;

			visited = new boolean[N][M];
			
			bfs();

			System.out.println("#" + tc + " " + sum);
		}
	}

	private static void bfs() {

		int cnt = 1;
		
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;
					if (visited[nr][nc] || map[nr][nc] == 'W')
						continue;
					
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
					sum += cnt;
					
				}
				
			}
			cnt++;
		}
	}
}
