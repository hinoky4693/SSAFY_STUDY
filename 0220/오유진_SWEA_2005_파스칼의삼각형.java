import java.util.Scanner;

public class Q2005 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N + 1];

			arr[0][1] = 1;
			for (int i = 1; i < N; i++) {
				for (int j = 1; j < N + 1; j++) {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}

			System.out.println("#" + tc );
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= i + 1; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
