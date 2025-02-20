import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int[][] temp = new int[N][N];
			int[][] temp1 = new int[N][N];
			int[][] temp2 = new int[N][N];
			int[][] res = new int[N][N];

			// 배열 입력 완료
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 90도 회전
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp[j][N - 1 - i] = arr[i][j];
				}
			}

			// 180도 회전
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp1[j][N - 1 - i] = temp[i][j];
				}
			}

			// 270도 회전
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp2[j][N - 1 - i] = temp1[i][j];
				}
			}
//			System.out.println(Arrays.deepToString(temp));
//			System.out.println(Arrays.deepToString(temp1));
//			System.out.println(Arrays.deepToString(temp2));

			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(temp[i][j]);
				}
				System.out.print(" ");
				for (int k = 0; k < N; k++) {
					System.out.print(temp1[i][k]);
				}
				System.out.print(" ");
				for (int m = 0; m < N; m++) {
					System.out.print(temp2[i][m]);
				}System.out.println();
			}
		}
	}
}
