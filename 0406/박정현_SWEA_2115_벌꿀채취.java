import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박정현_SWEA_2115_벌꿀채취 {
	static int N, M, C;
	static int max;
	static int[] sel, selected;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] arr = new int[(N - M + 1) * N][4];
			sel = new int[M];
			int aidx = 0;
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N - M + 1; i++) {
					int sum = 0;
					int idx = 0;
					max = Integer.MIN_VALUE;
					
					for (int j = i; j < i + M; j++) {
						sel[idx++] = map[k][j];
						sum += map[k][j];
					}
					
					if (sum > C) {
						for (int z = 1; z <= M; z++) {
							selected = new int[z];

							comb(i, i, 0, k, z);
						}
						arr[aidx++] = new int[] { max, k, i, i + M - 1 };
					} else {
						sum = 0;
						for (int a : sel) {
							sum += a * a;
						}
						arr[aidx++] = new int[] { sum, k, i, i + M - 1 };
					}

				}
			}

			Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);
			int[][] ans = new int[2][4];
			ans[0] = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[0][1] != arr[i][1]) {
					sb.append("#").append(tc).append(" ").append((ans[0][0] + arr[i][0]));
					sb.append("\n");
					break;
				} else {
					if (arr[0][3] >= arr[i][2]) {
						continue;
					}
					sb.append("#").append(tc).append(" ").append((ans[0][0] + arr[i][0]));
					sb.append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}

	private static void comb(int idx,int idx2, int sidx, int k, int R) {
		if (sidx == R) {
			int sum = 0;
			int sum2 = 0;
			for (int i = 0; i < R; i++) {
				sum += map[k][selected[i]];
				sum2 += map[k][selected[i]] * map[k][selected[i]];
				if (sum > C) {
					sum2 = Integer.MIN_VALUE;
					break;
				}
			}
			if (max < sum2)
				max = sum2;
			return;
		}
		for (int i = idx; i < idx2+M; i++) {
			selected[sidx] = i;
			comb(i + 1, idx2, sidx + 1, k, R);
		}

	}
}
