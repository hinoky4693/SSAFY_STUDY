import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 박정현_백준_1344_축구 {
	static double a, b;
	static int[] arr, sel;
	static double ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = Double.parseDouble(br.readLine()) / 100;
		b = Double.parseDouble(br.readLine()) / 100;
		arr = new int[] { 0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18 };
		sel = new int[2];
		perm(0);
		System.out.println(1-ans);
//		sel = new int[] {2,2};
//		System.out.println(calc());

	}

	private static void perm(int sidx) {
		if (sidx == 2) {
			ans += calc();
//			System.out.println(ans);
//			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			sel[sidx] = arr[i];
			perm(sidx + 1);
		}
	}

	private static double calc() {
		long temp1 = 1;
		long temp2 = 1;
		for (int i = 0; i < sel[0]; i++) {
			temp1 *= (18 - i);
			temp2 *= (sel[0] - i);
		}
		long temp3 = 1;
		long temp4 = 1;
		for (int i = 0; i < sel[1]; i++) {
			temp3 *= (18 - i);
			temp4 *= (sel[1] - i);
		}
//		System.out.println((temp1 / temp2) * Math.pow(a, sel[0]) * Math.pow(1-a, sel[0]));
//		System.out.println((temp3 / temp4) * Math.pow(b, sel[1]) * Math.pow(1-b, 18-sel[1]));
		double t1, t2;
		if (sel[0] == 0 || sel[0] == 18) {
			t1 = 1;
		} else {
			t1 = temp1 / (double) temp2;
		}
		
		if (sel[1] == 0 || sel[1] == 18) {
			t2 = 1;
		} else {
			t2 = temp3 / (double) temp4;
		}
		
		return (t1) * Math.pow(a, sel[0]) * Math.pow(1-a, 18-sel[0])
			 * (t2) * Math.pow(b, sel[1]) * Math.pow(1-b, 18-sel[1])                                                  ;
//		return (temp1 / temp2) * Math.pow(a, sel[0]) * Math.pow(1-a, 18-sel[0])
//				* (temp3 / temp4) * Math.pow(b, sel[1]) * Math.pow(1-b, 18-sel[1])                                                  ;
	}
}
