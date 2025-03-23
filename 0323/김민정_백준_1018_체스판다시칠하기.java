import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1018_체스판다시칠하기 {
	static char[][] chess;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		chess = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			chess[i] = st.nextToken().toCharArray();
		}
		
		ans = Integer.MAX_VALUE;
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				ans = Math.min(cntW(i, j), ans);
				ans = Math.min(cntB(i, j), ans);
			}
		}
		System.out.println(ans);
	}

	private static int cntW(int x, int y) {
		int cnt = 0;
		for (int i = x; i <= x + 7; i++) {
			for (int j = y; j <= y + 7; j++) {
				if ((i + j) % 2 == 0 && chess[i][j] == 'B') cnt++;
				else if ((i + j) % 2 == 1 && chess[i][j] == 'W') cnt++;
				if (cnt > ans) return ans;
			}
		}
		return cnt;
	}
	
	private static int cntB(int x, int y) {
		int cnt = 0;
		for (int i = x; i <= x + 7; i++) {
			for (int j = y; j <= y + 7; j++) {
				if ((i + j) % 2 == 0 && chess[i][j] == 'W') cnt++;
				else if ((i + j) % 2 == 1 && chess[i][j] == 'B') cnt++;
				if (cnt > ans) return ans;
			}
		}
		return cnt;
	}
}
