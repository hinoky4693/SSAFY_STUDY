

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 박정현_SWEA_2005_파스칼의삼각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] pascal = new int[N][N];
			for(int i=0;i<N;i++) {
				pascal[i][0] = 1;
			}
			for(int i=1;i<N;i++) {
				for(int j=1; j<=i; j++) {
					pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
				}
			}
			System.out.println("#"+tc);
			for(int i=0;i<N;i++) {
				for(int j=0; j<=i; j++) {
					System.out.print(pascal[i][j]+" ");
				}
				System.out.println();
			}
			
			
			
		}
		
	}
}
