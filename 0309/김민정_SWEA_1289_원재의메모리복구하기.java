import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1289_원재의메모리복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			String str = br.readLine();
			
			int cnt = 0;
			if (str.charAt(0) == '1') cnt++;
			for (int i = 0; i < str.length()-1; i++) {
				if (str.charAt(i) != str.charAt(i+1)) cnt++;
			}
			
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
