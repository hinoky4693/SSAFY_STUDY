import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 박정현_BOJ_7795_먹을것인가먹힐것인가 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			Set<Integer> aSet = new TreeSet<Integer>();
			for (int i = 0; i < a; i++) {
				aSet.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			Set<Integer> bSet = new TreeSet<Integer>();
			for (int i = 0; i < b; i++) {
				bSet.add(Integer.parseInt(st.nextToken()));
			}

			Object[] aArr = aSet.toArray();
			Object[] bArr = bSet.toArray();

			int sum = 0;
			for (int i = 0; i < bArr.length; i++) {
				int n = Arrays.binarySearch(aArr, bArr[i]);
				Set<Object> set = new TreeSet<Object>();
				if (n < 0)
					n = n * (-1) + 1;
				for (int j = n + 1; j < aArr.length; j++) {
					set.add(aArr[j]);
				}
				sum += set.size();
			}

			System.out.println(sum + 1);
		}
	}
}
