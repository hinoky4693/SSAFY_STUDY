import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박정현_SWEA_10966_물놀이를가자 {

	static int T, N, M, sum;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sum = 0;
			map = new int[N][M];
			for (int r = 0; r < N; r++) {
				String line = br.readLine();
				for (int c = 0; c < M; c++) {
					int data = line.charAt(c) - 'L';
					if (data != 0)
						q.add(new int[] { r, c });
					map[r][c] = line.charAt(c) - 'L';
				}
			}

			while (!q.isEmpty()) {
				int[] curr = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];

					if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
						q.add(new int[] { nr, nc });
						map[nr][nc] = map[curr[0]][curr[1]] + 1;
					}
				}
			}
			
			for(int r=0;r<N;r++) {
				for(int c=0;c<M;c++) {
					sum += (map[r][c] - 11);
				}
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
}
