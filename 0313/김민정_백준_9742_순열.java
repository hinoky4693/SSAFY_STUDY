import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9742_순열 {

	static char[] ch;
	static char[] sel;
	static boolean[] visited;
	static int cnt = 0;
	static List<char[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input;
		while ((input = br.readLine()) != null) {
			StringBuilder sb = new StringBuilder(input);

			if (sb.length() == 0)
				break;
			StringTokenizer st = new StringTokenizer(sb.toString());
			ch = st.nextToken().toCharArray();
			int num = Integer.parseInt(st.nextToken());

			int fact = 1;
			for (int i = ch.length; i > 0; i--) {
				fact *= i;
			}

			if (fact < num) {
				sb.append(" = No permutation");
			} else {
				sel = new char[ch.length];
				visited = new boolean[ch.length];
				list = new ArrayList<>();
				
				perm(0);
				
				sb.append(" = ");
				for (int i = 0; i < ch.length; i++) {
					sb.append(list.get(num - 1)[i]);
				}
				
			}

			System.out.println(sb);
		}
	}

	private static void perm(int idx) {
		if (idx == ch.length) {

			list.add(sel.clone());
			return;
		}
		for (int i = 0; i < ch.length; i++) {
			if (visited[i])
				continue;
			sel[idx] = ch[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}
}
