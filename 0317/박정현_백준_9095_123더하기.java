import java.util.Scanner;

public class 박정현_백준_9095_123더하기 {
	static int N, R;
	static int[] arr = {1, 2, 3};
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int n = sc.nextInt();
			N = n;
			int sum = 0;
			perm(sum);
			System.out.println(count);
			count = 0;
		}
	}


	private static void perm(int sum) {
		if (sum >= N) {
			if (sum == N) count++;
			return;
		} 
		
		for(int i=0;i<arr.length;i++) {
			perm(sum+arr[i]);
		}
	}
}
