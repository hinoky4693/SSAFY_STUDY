import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박정현_BOJ_2206_벽부수고이동하기 {

	static int N, M;
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		visited = new boolean[N][N];
		bfs(0, 0);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		int breakable = 1;
		q.add(new int[] { r, c, breakable });

		while (!q.isEmpty()) {
			
		}
	}
}
