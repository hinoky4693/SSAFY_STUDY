import java.util.Scanner;

public class 박정현_SWEA_10726_이진수표현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			boolean ans = true;
			for(int i=0;i<N;i++) {
				if ((M & (1<<i)) > 0) {
					continue;
				} else {
					ans = false;
					break;
				}
			}
			
			if(ans) System.out.println("#"+tc+" "+"ON");
			else System.out.println("#"+tc+" "+"OFF");
		}
		
	}
}
