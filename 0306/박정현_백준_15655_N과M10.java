import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 박정현_백준_15655_N과M10 {

	public static int[] data;
	public static int[] sel;
	public static List<int[]> temp;
	public static int N, R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = sc.nextInt();
		data = new int[N];
		sel = new int[R];
		temp = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}

		Arrays.sort(data);

		comb(0, 0);
		for (int i = 0; i < temp.size() - 1; i++) {
			for (int j = i + 1; j < temp.size(); j++) {
				if (Arrays.equals(temp.get(i), temp.get(j))) {
					temp.set(i, new int[] { -1, -1 });
				}
			}
		}

		for (int i = 0; i < temp.size(); i++) {
			if (!Arrays.equals(temp.get(i), new int[] { -1, -1 })) {
				for (int j = 0; j < R; j++) {
					System.out.print(temp.get(i)[j] + " ");
				}
				System.out.println();
			}
		}
	}

	private static void comb(int idx, int sidx) {
		// 종료조건
		if (sidx == R) {
			temp.add(sel.clone());
			return;
		}

		for (int i = idx; i < N; i++) {
			sel[sidx] = data[i];
			comb(i + 1, sidx + 1);
		}
	}
}