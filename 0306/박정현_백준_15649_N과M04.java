import java.util.Scanner;

public class 박정현_백준_15649_N과M04 {
	
	public static int[] sel;
	public static int N,R;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		sel = new int[N];
		
//		comb(0,0);
		comb2(0,0);
	}

	private static void comb(int idx, int sidx) {
		// 종료조건
		if (sidx >= R) {
			for(int i=0;i<R;i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		if (idx >= N) {
			return;
		}
		
		// 재귀조건
		sel[sidx] = idx+1;
		comb(idx+1, sidx+1);
		comb(idx+1, sidx);
	}
	
	private static void comb2(int idx, int sidx) {
		// 종료조건
		if (sidx == R) {
			for(int i=0;i<R;i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		// 재귀조건
		for(int i=idx; i<N;i++) {
			sel[sidx] = i+1;
			comb2(i, sidx+1);
		}
	}
	
	
	
}
