import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박정현_SWEA_4047_영준이의카드카운팅 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		Loop:
		for (int tc = 1; tc <= T; tc++) {
			int[] S = new int[13];
			int[] D = new int[13];
			int[] H = new int[13];
			int[] C = new int[13];
			String words = br.readLine();
			words = words.replace("S", " S");
			words = words.replace("D", " D");
			words = words.replace("H", " H");
			words = words.replace("C", " C");
			StringTokenizer st = new StringTokenizer(words);
			while (st.hasMoreTokens()) {
				String nextWord = st.nextToken();
				if (nextWord.charAt(0) == 'S') {
					S[(nextWord.charAt(1) - '0') * 10 + (nextWord.charAt(2) - '0')-1]++;
				} else if (nextWord.charAt(0) == 'D') {
					D[(nextWord.charAt(1) - '0') * 10 + (nextWord.charAt(2) - '0')-1]++;
				} else if (nextWord.charAt(0) == 'H') {
					H[(nextWord.charAt(1) - '0') * 10 + (nextWord.charAt(2) - '0')-1]++;
				} else if (nextWord.charAt(0) == 'C') {
					C[(nextWord.charAt(1) - '0') * 10 + (nextWord.charAt(2) - '0')-1]++;
				}
			}

			int countS = 13;
			int countD = 13;
			int countH = 13;
			int countC = 13;
			for (int i = 0; i < 13; i++) {
				if (S[i] > 1 || D[i] > 1 || H[i] > 1 || C[i] > 1) {
					System.out.println("#" + tc + " ERROR");
					continue Loop;
				}
				if(S[i] == 1) countS--;
				if(D[i] == 1) countD--;
				if(H[i] == 1) countH--;
				if(C[i] == 1) countC--;
			}

			System.out.println("#"+tc+" "+countS+" "+ countD +" "+ countH +" "+ countC); 
		}
	}
}
