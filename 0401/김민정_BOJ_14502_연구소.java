import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502_연구소 {
	
	static int N, M, ans;
	static int[][] map, tmpMap;
	static List<int[]> list;
	static int[][] sel;
	static Queue<int[]> q, tmpQ;
	static boolean[][] visited, visited2;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited2 = new boolean[N][M];
		list = new ArrayList<>();
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new int[] {i, j});
				} else if (map[i][j] == 2) {
					q.add(new int[] {i, j});
					visited2[i][j] = true;
					
				}
			}
		}
		
		ans = Integer.MIN_VALUE;
		tmpQ = deepCopyQueue(q);
		tmpMap = deepCopyMap(map);
		sel = new int[3][2];
		comb(0, 0);
		
		System.out.println(ans);
	}

	private static void comb(int idx, int sidx) {
		if (sidx == 3) {
			for (int i = 0; i < 3; i++) {
				map[sel[i][0]][sel[i][1]] = 1;
			}
			visited = deepCopyBool(visited2);
			bfs();
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) cnt++;
				}
			}
			ans = Math.max(ans, cnt);
			for (int i = 0; i < 3; i++) {
				map[sel[i][0]][sel[i][1]] = 0;
			}
			map = deepCopyMap(tmpMap);
			q = deepCopyQueue(tmpQ);
			return;
		}
		
		for (int i = idx; i < list.size(); i++) {
			sel[sidx] = list.get(i).clone();
			comb(i+1, sidx+1);
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (visited[nr][nc] || map[nr][nc] != 0) continue;
				
				visited[nr][nc] = true;
				map[nr][nc] = 2;
				q.add(new int[] {nr, nc});
			}
		}
	}
	
	public static Queue<int[]> deepCopyQueue(Queue<int[]> original) {
	    Queue<int[]> copy = new LinkedList<>();
	    for (int[] arr : original) {
	        copy.add(Arrays.copyOf(arr, arr.length));
	    }
	    return copy;
	}
	
	public static int[][] deepCopyMap(int[][] original) {
	    int[][] copy = new int[original.length][];
	    for (int i = 0; i < original.length; i++) {
	        copy[i] = Arrays.copyOf(original[i], original[i].length);
	    }
	    return copy;
	}

	public static boolean[][] deepCopyBool(boolean[][] original) {
	    boolean[][] copy = new boolean[original.length][];
	    for (int i = 0; i < original.length; i++) {
	        copy[i] = Arrays.copyOf(original[i], original[i].length);
	    }
	    return copy;
	}



}
