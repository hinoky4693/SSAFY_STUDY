package studyyyy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA7272 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		Map<Character, Integer> alpha = new HashMap<>();
		alpha.put('B', 2);
		alpha.put('A', 1);
		alpha.put('D', 1);
		alpha.put('O', 1);
		alpha.put('P', 1);
		alpha.put('Q', 1);
		alpha.put('R', 1);
		alpha.put('C', 0);
		alpha.put('E', 0);
		alpha.put('F', 0);
		alpha.put('G', 0);
		alpha.put('H', 0);
		alpha.put('I', 0);
		alpha.put('J', 0);
		alpha.put('K', 0);
		alpha.put('L', 0);
		alpha.put('M', 0);
		alpha.put('N', 0);
		alpha.put('S', 0);
		alpha.put('T', 0);
		alpha.put('U', 0);
		alpha.put('V', 0);
		alpha.put('W', 0);
		alpha.put('X', 0);
		alpha.put('Y', 0);
		alpha.put('Z', 0);
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			String ans = "SAME";

			if (str1.length() != str2.length()) {
				ans = "DIFF";
			} else {
				for (int i = 0; i < str1.length(); i++) {
					if (alpha.get(str1.charAt(i)) != alpha.get(str2.charAt(i))) {
						ans = "DIFF";
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
