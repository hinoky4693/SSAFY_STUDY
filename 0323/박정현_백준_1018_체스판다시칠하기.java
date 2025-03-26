import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박정현_백준_1018_체스판다시칠하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] chess = new char[N][M];
		for (int i = 0; i < N; i++) {
			chess[i] = br.readLine().toCharArray();
		}
		int minCount = 0;
		for (int r = 0; r < N - 7; r++) {
			for (int c = 0; c < M - 7; c++) {
				System.out.println("r : " + r + " c : " + c);
				int count1 = 0;
				int count2 = 0;
				if (c % 2 == 0) { // 세로줄 짝수일 때,
					for (int i = c; i < c + 8; i++) {
						if (r % 2 == 0) {
							for (int j = r; j < r + 8; j++) { // 가로줄 짝수일 때,
								if (chess[j][i] == 'B')
									count1++;
							}
							for (int j = r; j < r + 8; j++) { // 가로줄 짝수일 때,
								if (chess[j][i] == 'W')
									count2++;
							}
						} else {
							for (int j = r + 1; j < r + 9; j++) { // 가로줄 홀수일 때,
								if (chess[j][i] == 'W')
									count1++;
							}
							for (int j = r + 1; j < r + 9; j++) { // 가로줄 홀수일 때,
								if (chess[j][i] == 'B')
									count2++;
							}
						}
					}
				} else { // 세로줄 홀수일 때,
					for (int i = c + 1; i < c + 8; i++) {
						if ( r % 2 == 0) {
							for (int j = r; j < r + 8; j++) { // 가로줄 짝수일 때,
								if (chess[j][i] == 'W')
									count1++;
							}
							for (int j = r; j < r + 8; j++) { // 가로줄 짝수일 때,
								if (chess[j][i] == 'B')
									count2++;
							}
						} else {
							for (int j = r + 1; j < r + 9; j++) { // 가로줄 홀수일 때,
								if (chess[j][i] == 'B')
									count1++;
							}
							for (int j = r + 1; j < r + 9; j++) { // 가로줄 홀수일 때,
								if (chess[j][i] == 'W')
									count2++;
							}
						}
					}
				}
				minCount = Math.min(count1, count2);
			}
		}
		System.out.println(minCount);
	}
}