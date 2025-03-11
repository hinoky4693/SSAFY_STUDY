import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA10726_이진수표현_비트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String ans = "ON";
			for (int i = 0; i < N; i++) {
				if ((M & (1<<i)) == 0) {
					ans = "OFF";
					break;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
