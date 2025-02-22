package studyyyy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA4698_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			
			boolean[] isPrime = new boolean[B + 1];
			Arrays.fill(isPrime, true);
			isPrime[0] = isPrime[1] = false;
			
			for (int i = 2; i * i <= B; i++) {
				if (isPrime[i]) {
					for (int j = i * i; j <= B; j+=i) {
						isPrime[j] = false;
					}
				}
			}

			int cnt = 0;
			for (int i = A; i <= B; i++) {
                if (isPrime[i] && String.valueOf(i).contains(D)) {
                    cnt++;
                }
			}

			System.out.println("#" + tc + " " + cnt);
		}
		
	}
}




