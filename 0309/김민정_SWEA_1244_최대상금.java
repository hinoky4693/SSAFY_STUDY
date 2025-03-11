import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1244_최대상금_조합 {
	static int[] num;
	static int[] num2;
	static int C;
	static Integer[] sel;
	static Integer[] sel2;
	static int max;
	static StringBuilder sb;
	static List<Integer[]> list;
	static Integer[] nnn;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] N = st.nextToken().toCharArray();
			C = Integer.parseInt(st.nextToken());
			num = new int[N.length];

			for (int i = 0; i < N.length; i++) {
				num[i] = Integer.parseInt(N[i] + "");
			}
			
			num2 = num.clone();

			max = Integer.MIN_VALUE;
			sb = new StringBuilder();
			sel = new Integer[2];
			sel2 = new Integer[C];
			list = new ArrayList<>();

			comb(0, 0);
			comb2(0, 0);

			System.out.println("#" + tc + " " + max);
		}
	}

	public static void comb2(int idx, int sidx) {
		if (sidx == C) {
			for (int i = 0; i < C; i++) {
				nnn = list.get(sel2[i]);
				System.out.println("ii " + i + " " + Arrays.toString(nnn));
				swap(nnn[0], nnn[1]);
			}
			for (int j = 0; j < num.length; j++) {
				sb.append(num[j]);
			}
			max = Math.max(max, Integer.parseInt(sb.toString()));
			num = num2.clone();
			sb.setLength(0);

			return;
		}
		
		for (int i = 0; i < list.size(); i++) {
			sel2[sidx] = i;
			comb2(i + 1, sidx + 1);
		}
	}

	public static void comb(int idx, int sidx) {
		if (sidx == 2) {
			list.add(sel.clone());
			return;
		}
		for (int i = idx; i < num.length; i++) {
			sel[sidx] = i;
			comb(i + 1, sidx + 1);
		}
	}

	public static void swap(int idx1, int idx2) {
		int tmp = num[idx1];
		num[idx1] = num[idx2];
		num[idx2] = tmp;
	}
}
