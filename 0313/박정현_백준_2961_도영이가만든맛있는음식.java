import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박정현_백준_2961_도영이가만든맛있는음식 {
	static int[] S, B, sel;
	static int N, sSum, bSum, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		sSum = 1;
		bSum = 0;
		ans = Integer.MAX_VALUE;
		for (int tc = 0; tc < N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[tc] = Integer.parseInt(st.nextToken());
			B[tc] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1;i<=N;i++) {
			sel = new int[i];
			cook(0, 0, i);
		}
		System.out.println(ans);

	}

	private static void cook(int idx, int sidx, int R) {
		
		// 종료 조건
		if (sidx == R) {
			for(int i=0;i<R;i++) {
				sSum *= S[sel[i]];
				bSum += B[sel[i]];
			}
			
			ans = Math.min(Math.abs(sSum-bSum), ans);
			sSum = 1;
			bSum = 0;
			return;
		}
		
		// 재귀 조건
		for (int i = idx; i <= N - R + sidx; i++) {
			sel[sidx] = i;
			cook(i+1, sidx+1, R);
		}
	}
}
