import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652_N과M4 {
	static int N, M;
	static int[] sel;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sel = new int[M];
		comb(1, 0);
		
	}

	public static void comb(int idx, int sidx) {
		if (sidx == M) {
			for (int n : sel) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			sel[sidx] = i;
			comb(i, sidx+1);
		}
		
	}
}
