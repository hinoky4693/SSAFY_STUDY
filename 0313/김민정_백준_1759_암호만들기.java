import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759_암호만들기 {
	static int L, C;
	static String[] sel;
	static String[] str;
	static int v, nv;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		str = new String[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			str[i] = st.nextToken();
		}
		Arrays.sort(str);
		
		sel = new String[L];
		sb = new StringBuilder();
		comb(0, 0);
		
		
	}

	private static void comb(int idx, int sidx) {
		if (sidx == L) {
			v = 0; nv = 0;
			for (String c : sel) {
				if (c.equals("a") || c.equals("e") || 
						c.equals("i") || c.equals("o") || c.equals("u")) {
					v++;
				} else nv++;
			}
			if (v >= 1 && nv >= 2) {
				for (String c : sel) {
					sb.append(c);
				}
				System.out.println(sb);
				sb.setLength(0);;
			}
			return;
		}
		
		for (int i = idx; i < C; i++) {
			sel[sidx] = str[i];
			comb(i+1, sidx+1);
		}
	}
	
}
