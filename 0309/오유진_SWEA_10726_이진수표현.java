import java.util.Scanner;

public class Q10726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			boolean isTrue = false;
			for (int i = 0; i < N; i++) {
				if ((M & (1 << i)) != 0) {
					isTrue = true;
				} else {
					isTrue = false;
					break;
				}
			}
			if (isTrue) {
				System.out.println("#" + tc + " ON");
			} else {
				System.out.println("#" + tc + " OFF");
			}

		}
	}
}
