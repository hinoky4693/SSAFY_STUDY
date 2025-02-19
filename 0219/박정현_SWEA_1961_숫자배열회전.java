import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박정현_SWEA_1961_숫자배열회전 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 T 입력

		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 반복문
			int N = Integer.parseInt(br.readLine()); // 이차원 배열 크기 N 입력
			int[][] nums = new int[N][N]; // 이차원 배열 담을 변수 선언

			// 이차원 배열 담기
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+tc);
			for (int j = 0; j < N; j++) {
				for (int a = 0; a < N; a++) {
					System.out.print(nums[N - 1 - a][j]);
				}
				System.out.print(" ");
				for (int b = 0; b < N; b++) {
					System.out.print(nums[N - 1 - j][N - 1 - b]);
				}
				System.out.print(" ");
				for (int c = 0; c < N; c++) {
					System.out.print(nums[c][N - 1 - j]);
				}
				System.out.println();
			}
		}
	}
}
