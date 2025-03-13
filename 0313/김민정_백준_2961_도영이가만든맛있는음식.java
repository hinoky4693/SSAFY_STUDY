import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961_도영이가만든맛있는음식 {
	
	static int N;
	static int min;
	static int[] sel;
	static int[][] taste;
	static int sour;
	static int bitter;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		taste = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			sel = new int[i];
			comb(0, 0, i);
		}
		
		System.out.println(min);
	}

	private static void comb(int idx, int sidx, int len) {
		if (sidx == len) {
			sour = 1;
			bitter = 0;
			for (int s : sel) {
				sour *= taste[s][0];
				bitter += taste[s][1];
			}
			min = Math.min(min, Math.abs(sour-bitter));
			return;
		}
		
		for (int i = idx; i < N; i++) {
			sel[sidx] = i;
			comb(i+1, sidx+1, len);
		}
		
	}
}
