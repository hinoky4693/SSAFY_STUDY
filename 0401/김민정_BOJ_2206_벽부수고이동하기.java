import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206_벽부수고이동하기 {
	
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		
		
		int ans = bfs(0, 0);
		if (ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
		
	}
	
	
	
	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {r, c, 0});  // [2] -> 0 : 아직 안 부숨 , 1: 부숨
		visited[r][c][0] = true;
//		visited[r][c][1] = true;
		
		int cnt = 1;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();
				
				if (curr[0] == N-1 && curr[1] == M-1) return cnt;
				
				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					
					if (visited[nr][nc][curr[2]]) continue;
					
					if (map[nr][nc] == 1) {
						if (curr[2] == 0) {
							q.add(new int[] {nr, nc, 1});
							visited[nr][nc][1] = true;
						} else if (curr[2] == 1) {
							continue;
						}
					} else {
						if (curr[2] == 1) {
							visited[nr][nc][1] = true;
							q.add(new int[] {nr, nc, 1}); 
						} else {
							visited[nr][nc][0] = true;
							q.add(new int[] {nr, nc, 0});
						}
					}
				}
			}
			
			cnt++;
		}
		return Integer.MAX_VALUE;
	}




}
