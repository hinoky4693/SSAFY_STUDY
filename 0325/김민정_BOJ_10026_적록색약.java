import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026_적록색약 {
	
	static char[][] colors;
	static int N, cntRGB, cntRB;
	static boolean[][] visited, visited2;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		colors = new char[N][N];
		for (int i = 0; i < N; i++) {
			colors[i] = br.readLine().toCharArray();
		}
		
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, colors[i][j]);
					cntRGB++;
				}
				if (!visited2[i][j]) {
					dfs2(i, j, colors[i][j]);
					cntRB++;
				}
			}
		}
		
		
		System.out.println(cntRGB + " " + cntRB);
	}

	private static void dfs2(int r, int c, char color) {
		visited2[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if (color == 'B' && colors[nr][nc] != 'B') continue;
			if (color != 'B' && colors[nr][nc] == 'B') continue;
			if (visited2[nr][nc]) continue;
			
			visited2[nr][nc] = true;
			dfs2(nr, nc, color);
		}
	}

	private static void dfs(int r, int c, char color) {
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if (colors[nr][nc] != color) continue;
			if (visited[nr][nc]) continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc, color);
		}
		
	}
}
