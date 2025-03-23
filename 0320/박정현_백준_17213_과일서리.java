import java.util.Arrays;
import java.util.Scanner;

public class 박정현_백준_17213_과일서리 {
	static int N, M, sum, ans;
	static int[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M-N];
		sum = 0;
		comb(0,0);
		System.out.println(ans);
	}

	private static void comb(int idx, int sidx) {
		if (sidx == sel.length) {
//			System.out.println(Arrays.toString(sel));
			ans++;
			return;
		}
		
		for(int i=idx;i<N;i++) {
			sel[sidx] = i;
			comb(i, sidx + 1);
		}
	}
}
