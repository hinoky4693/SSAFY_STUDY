import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박정현_BOJ_17136_색종이붙이기 {
	static int[][] map = new int[10][10];
	static int[] paper = { 0, 5, 5, 5, 5, 5 }; // 1~5 크기 색종이 각 5장
	static int min = Integer.MAX_VALUE;

	public static void dfs(int r, int c, int used) {
		if (r >= 10) {
			min = Math.min(min, used);
			return;
		}

		if (c >= 10) {
			dfs(r + 1, 0, used);
			return;
		}

		if (map[r][c] == 1) {
			for (int size = 5; size >= 1; size--) {
				if (canAttach(r, c, size) && paper[size] > 0) {
					attach(r, c, size, 0); // 붙이기
					paper[size]--;
					dfs(r, c + 1, used + 1);
					attach(r, c, size, 1); // 복구
					paper[size]++;
				}
			}
		} else {
			dfs(r, c + 1, used);
		}
	}

	static boolean canAttach(int r, int c, int size) {
		if (r + size > 10 || c + size > 10)
			return false;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] != 1)
					return false;
			}
		}
		return true;
	}

	static void attach(int r, int c, int size, int val) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				map[i][j] = val;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}

		dfs(0, 0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
}