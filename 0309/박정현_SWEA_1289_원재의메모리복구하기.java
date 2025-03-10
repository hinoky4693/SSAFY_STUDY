import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 박정현_SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			String data = br.readLine();
			if (data.charAt(data.length()-1) == 0) ans++;
			if (data.charAt(0) == 1) ans++;
			for (int i = data.length() - 1; i >= 1; i--) {
				if (data.charAt(i) == data.charAt(i-1)) {
					continue;
				} else {
					ans++;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}

	}
}
