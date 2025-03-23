import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1344_축구 {
	
	static int[] composite = {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};
	static double winA, winB;
	static int[] sel;
	static double prob;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		winA = Integer.parseInt(br.readLine()) / 100.0;
		winB = Integer.parseInt(br.readLine()) / 100.0;
	
		prob = 0.0;
		
		sel = new int[2];
		perm(0);
		System.out.println(1 - prob);
	}

	private static void perm(int idx) {
		if (idx == 2) {
			calProb(sel[0], sel[1]);
			return;
		}
		for (int i = 0; i < composite.length; i++) {
			sel[idx] = composite[i];
			perm(idx+1);
		}
	}

	private static void calProb(int a, int b) {
		double aa = calComb(a);  // 18Ca
		double bb = calComb(b);

		
		prob +=   (aa * Math.pow(winA, a) * Math.pow(1-winA, 18-a)) 
				* (bb * Math.pow(winB, b) * Math.pow(1-winB, 18-b));
		
	}

	private static double calComb(int n) {
		double mul = 1;
		if (n == 0 || n == 18) return 1;
	    for (int i = 1; i <= n; i++) {
	        mul *= (18 - i + 1) / (double) i;
	    }
		return mul;
	}
}
