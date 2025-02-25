import java.util.*;
import java.io.*;

public class 박정현_SWEA_2007_패턴마디의길이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String words = br.readLine();
			StringBuilder pattern = new StringBuilder();
			pattern.append(words.charAt(0));
			int ans = 0;
			for(int i=1;i<10;i++) {
				if (words.charAt(i) == words.charAt(0)) {
					StringBuilder temp = new StringBuilder();
					for(int j=i;j<2*i;j++) {
						temp.append(words.charAt(j));
					}
					
					if (pattern.toString().equals(temp.toString())) {
						ans = pattern.length();
						break;
					}
					else pattern.append(words.charAt(i));
				} else {
					pattern.append(words.charAt(i));
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(ans);
			System.out.println(sb);
		}

	}

}
