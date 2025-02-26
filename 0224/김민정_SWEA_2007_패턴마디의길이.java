package studyyyy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2007 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < str.length(); i++) {
				sb.append(str.charAt(i));
				if (str.substring(i+1, i+1+sb.length()).equals(sb.toString())) {
					break;
				}
			}
			System.out.println("#" + tc + " " + sb.length());
		}
	}
}
