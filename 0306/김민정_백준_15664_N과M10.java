import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15664_N과M10 {
	static int N, M;
	static Integer[] sel;
	static int[] arr;
	static List<Integer[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		sel = new Integer[M];
		comb(0, 0);


	}

	public static void comb(int idx, int sidx) {
		if (sidx == M) {
			for (int i = 0; i < list.size(); i++) {
				if (Arrays.equals(sel, list.get(i))) return;
			}
			list.add(sel.clone());
			for (int n : sel) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}

		for (int i = idx; i < N; i++) {
			sel[sidx] = arr[i];
			comb(i, sidx + 1);
		}

	}
}
