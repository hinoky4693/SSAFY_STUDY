import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1072_게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		
		if (X == Y) {
			System.out.println(-1);
		} else {
			int t = (int)((Y * 100.0 / X) + 1);
			
			if (t == 100) System.out.println(-1); 
			else {
				double ans = (t*X - 100*Y) / (100.0-t);
				
				if (ans == (int)ans) System.out.println((int)ans);
				else System.out.println(((int)ans)+1);
			}
		}
		
	}
}
