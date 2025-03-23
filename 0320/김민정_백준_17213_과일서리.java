import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

//public class BOJ17213_과일서리 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int N = Integer.parseInt(br.readLine());
//		int M = Integer.parseInt(br.readLine());
//		
//		int r = M - N;
//		BigInteger fact = new BigInteger("1");
//		for (int i = (N+r-1); i > r; i--) {
//			fact = fact.multiply(BigInteger.valueOf(i));
//		}
//		BigInteger fact2 = new BigInteger("1");
//		for (int i = N-1; i > 0; i--) {
//			fact2 = fact2.multiply(BigInteger.valueOf(i));
//		}
//		System.out.println(fact.divide(fact2));
//	}
//}

//public class BOJ17213_과일서리 {
//	
//	static int N, M, cnt;
//	static int[] arr;
//	static int[] sel;
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		N = Integer.parseInt(br.readLine());
//		M = Integer.parseInt(br.readLine());
//
//		
//		sel = new int[M-N];
//		cnt = 0;
//		comb(0, 0);
//		
//
//		System.out.println(cnt);
//	}
//
//	private static void comb(int idx, int sidx) {
//		if (sidx == M-N) {
//			cnt++;
//			return;
//		}
//		for (int i = idx; i < N; i++) {
//			sel[sidx] = i;
//			comb(i, sidx+1);
//			
//		}
// 	}
//}

public class BOJ17213_과일서리 {
	
	static int N, M, cnt, r;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		
		cnt = 0;
		r = M-N;
		perm(0, 0);
		
		System.out.println(cnt);
	}

	private static void perm(int idx, int sum) {
		if (idx == N) {
			if (sum == r)
				cnt++;
			return;
		}
		for (int i = 0; i <= r; i++) {
			if (sum > r) return;
			perm(idx+1, sum+i);
		}
	}

}
