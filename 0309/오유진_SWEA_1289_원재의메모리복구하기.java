import java.util.Arrays;
import java.util.Scanner;

public class Q1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int[] ans = new int[str.length()];
			int cnt = 1;
			for (int i = 0; i < str.length(); i++) {
				if ((str.charAt(i) - '0') != ans[i]) {
					if ((str.charAt(i) - '0') == 1) {
						for (int j = i; j < ans.length; j++) {
							ans[j] = 1;
						}
						boolean isSame = false;
						for (int k = 0; k < str.length(); k++) {
							if ((str.charAt(k) - '0') == ans[k]) {
								isSame = true;
							} else {
								isSame = false;
								break;
							}
						}
						if (isSame) {
							break;
						} else {
							cnt++;
							continue;
						}
					} else if ((str.charAt(i) - '0') == 0) {
						for (int j = i; j < ans.length; j++) {
							ans[j] = 0;
						}
						boolean isSame = false;
						for (int k = 0; k < str.length(); k++) {
							if ((str.charAt(k) - '0') == ans[k]) {
								isSame = true;
							} else {
								isSame = false;
								break;
							}
						}
						if (isSame) {
							break;
						} else {
							cnt++;
							continue;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
