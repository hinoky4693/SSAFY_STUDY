import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095_123더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(sum(N));
		}
	}

	private static int sum(int n) {
		if (n == 1) return 1;
		else if (n == 2) return 2;
		else if (n == 3) return 4;
		
		return sum(n-1) + sum(n-2) + sum(n-3); 
		
	}
}
