import java.util.Scanner;

public class Q4698 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int num = 0;
			int count = 0;
			int primeCount = 0;
			int primeNumber = 0;
			for (int i = A; i <= B; i++) {
				for (int j = 2; j <= B; j++) {
					if (i % j == 0) {
						count++;
					}
				}
				if (count == 1) {
					primeNumber = i;
					String str = primeNumber + " ";
					char[] arr = str.toCharArray();
					for (int k = 0; k < arr.length; k++) {
						if (str.charAt(k)-'0' == D) {
							primeCount++;
						}
					}
				}
				count = 0;
			}
			System.out.println("#" + tc + " " + primeCount);
		}
	}
}
