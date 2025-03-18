import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17626_FourSquares {
	static boolean isOk;
	static int cnt;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		
		if (Math.ceil(Math.sqrt(N)) == (int)Math.sqrt(N)) {
			System.out.println(1);
			return;
		} else {
			isOk = false;
			int ans = 0;
			for (int i = 2; i <= 3; i++) {
				comb(0, 0, i, 0);
				if (isOk) {
					ans = i;
					System.out.println(ans);
					return;
				}
			}
			if (!isOk) System.out.println(4);
			
		}
	}

	private static void comb(int idx, int sidx, int len, int sum) {
		if (sidx == len) {
			if (sum == N) {
				isOk = true;
			}
			return;
		}
		
		for (int i = (int)Math.sqrt(N); i >= 0; i--) {
			if (sum + i*i > N) continue;
			comb(i, sidx+1, len, sum+i*i);
		}
		
	}
}
