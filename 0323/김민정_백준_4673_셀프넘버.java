import java.util.Arrays;

public class BOJ4673_셀프넘버 {
	public static void main(String[] args) {
		boolean[] isTrue = new boolean[10001];
		Arrays.fill(isTrue, true);
		isTrue[0] = false;
		
		for (int i = 1; i <= 10000; i++) {
			if (isTrue[i]) {
				int check = i;
				int sum = i;
				while (true) {
					int len = (check+"").length();
					for (int j = 0; j < len; j++) {
						sum += (check+"").charAt(j)-'0';
					}
					if (sum > 10000) break;
					isTrue[sum] = false;
					check = sum;
				}
				
			}
		}
		
		
		for (int i = 1; i <= 10000; i++) {
			if (isTrue[i]) System.out.println(i);
		}
	}
}
