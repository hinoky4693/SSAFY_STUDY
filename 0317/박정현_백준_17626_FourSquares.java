import java.util.Arrays;
import java.util.Scanner;

public class 박정현_백준_17626_FourSquares {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int original = sc.nextInt();
		int count = 0;

		int[] arr = new int[4];
		int num = original;
		while (true) {
			while (num > 0) {
				int i = 0;
				if (count == 4) {
					count = 0;
					arr[count]--;
					num = original;
					i = 0;
				}
				while (i * i <= num) {
					i++;
				}
				if (i == 1) {
					num--;
					arr[count] = i - 1;
					count++;
				} else {
					arr[count] = i - 1;
					num -= (i - 1) * (i - 1);
					count++;
				}
			}
			
			System.out.println(Arrays.toString(arr));
			if (num == 0) break;
			
		}

	}
}
