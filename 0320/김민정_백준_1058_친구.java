import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1058_친구 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		char[][] test = new char[N][N];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'Y') {
					test[i][j] = 'Y';
					for (int k = 0; k < N; k++) {
						if (arr[j][k] == 'Y') {
							test[i][k] = 'Y';
						}
					}
				}
			}
		}
		
		System.out.println(Arrays.deepToString(test));
		
		int ans = -1;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (i != j && test[i][j] == 'Y') cnt++;
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
