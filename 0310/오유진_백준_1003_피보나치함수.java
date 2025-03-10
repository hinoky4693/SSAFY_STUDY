import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			List<Integer> zero = new ArrayList<>();
			zero.add(0, 1);
			zero.add(1, 0);
			zero.add(2, 1);
			for (int i = 3; i < 41; i++) {
				zero.add(i, zero.get(i - 1) + zero.get(i - 2));
			}
			List<Integer> one = new ArrayList<>();
			one.add(0, 0);
			one.add(1, 1);
			one.add(2, 1);
			for (int i = 3; i < 41; i++) {
				one.add(i, one.get(i - 1) + one.get(i - 2));
			}
			System.out.print(zero.get(N) + " " + one.get(N));
			System.out.println();
		}
	}
}
