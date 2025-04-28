import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2115_벌꿀채취 {
	
	static int M, C;
	static int[][] map;
	static String[] type, sel;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			type = new String[(N - M + 1) * N];
			
			int tmp = 0; int i = 0;
			for (int jj = 0; jj < N; jj++) {
				for (int j = 0; j < N - M + 1; j++) {
					type[i++] = (tmp + "") + (j + "");
				}
				tmp++;
			}
			System.out.println(Arrays.toString(type));
			
			sel = new String[2];
			ans = Integer.MIN_VALUE;
			comb(0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void comb(int idx, int sidx) {
		if (sidx == 2) {
			if (sel[0].charAt(0) != sel[1].charAt(0)) {
				calc(sel[0], sel[1]);
			} else {
				if (sel[0].charAt(1)-'0' + M <= sel[1].charAt(1)-'0') {
					calc(sel[0], sel[1]);
				}
			}
			return;
		}
		for (int i = idx; i < type.length; i++) {
			sel[sidx] = type[i];
			comb(i+1, sidx+1);
		}
	}

	private static void calc(String str1, String str2) {
		int r1 = str1.charAt(0)-'0';
		int c1 = str1.charAt(1)-'0';
		int r2 = str2.charAt(0)-'0';
		int c2 = str2.charAt(1)-'0';
		
//		System.out.println("calc " + str1 + " " + str2);
		
		int[] sel1 = new int[M+1];
		System.arraycopy(map[r1], c1, sel1, 1, M);
		int[] sel2 = new int[M+1];
		System.arraycopy(map[r2], c2, sel2, 1, M);
		
		int[][] dp1 = new int[M+1][C+1];
		for (int i = 1; i <= M; i++) {
			for (int w = 0; w <= C; w++) {
				if (sel1[i] <= w) {
					dp1[i][w] = Math.max(dp1[i-1][w], dp1[i-1][w-sel1[i]]+sel1[i] * sel1[i]);
				} else {
					dp1[i][w] = dp1[i-1][w];
				}
			}
		}
		
		int[][] dp2 = new int[M+1][C+1];
		for (int i = 1; i <= M; i++) {
			for (int w = 0; w <= C; w++) {
				if (sel2[i] <= w) {
					dp2[i][w] = Math.max(dp2[i-1][w], dp2[i-1][w-sel2[i]]+sel2[i] * sel2[i]);
				} else {
					dp2[i][w] = dp2[i-1][w];
				}
			}
		}
		
		ans = Math.max(ans, dp1[M][C] + dp2[M][C]);
	}
}
