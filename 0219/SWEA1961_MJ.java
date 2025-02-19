import java.util.Arrays;
import java.util.Scanner;

public class SWEA1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt(); // NxN 행렬
			
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int[][] arr2 = new int[N][N];  // 90도 회전
			int[][] arr3 = new int[N][N];  // 180도 회전
			int[][] arr4 = new int[N][N];  // 270도 회전
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr2[j][N-1-i] = arr[i][j];
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr3[j][N-1-i] = arr2[i][j];
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr4[j][N-1-i] = arr3[i][j];
				}
			}
			
			System.out.println("#" + tc + " ");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(arr2[i][j]);
				}
				System.out.print(" ");
				for(int j = 0; j < N; j++) {
					System.out.print(arr3[i][j]);
				}
				System.out.print(" ");
				for(int j = 0; j < N; j++) {
					System.out.print(arr4[i][j]);
				}
				System.out.println();
			}
			
		}
	}
}
