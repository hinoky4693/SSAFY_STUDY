import java.util.Scanner;

public class Q1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int[] arr = new int[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i) - '0';
			}
			int num = sc.nextInt(); // 교환횟수

			for (int n = 0; n < num; n++) {
				int max = Integer.MIN_VALUE;
				for (int i = arr.length - 1; i >= 0; i--) {
					if (num == 1) {
						if (max < arr[i]) {
							max = arr[i];
							if (arr[arr.length - 1 - i] < max) {
								int tmp = arr[i];
								arr[i] = arr[arr.length - 1 - i];
								arr[arr.length - 1 - i] = tmp;
							}
						}
					}
					else {
						
					}
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
	}
}
