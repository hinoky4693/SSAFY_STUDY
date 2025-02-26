package studyyyy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA7087 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] alpha = new int[26];
			for (int i = 0; i < N; i++) {
				alpha[br.readLine().charAt(0)-'A']++;
			}
			
			int ans = 26;
			for (int i = 0; i < 26; i++) {
				if (alpha[i] == 0) {
					ans = i;
					break;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
