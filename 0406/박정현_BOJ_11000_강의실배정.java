import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 박정현_BOJ_11000_강의실배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<boolean[]> list = new ArrayList<>();
		list.add(new boolean[1000000000]);
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			boolean check = false;
			for (int k = 0; k < list.size(); k++) {
				for (int j = S; j < T; j++) {
					if (list.get(k)[j]) {
						check = true;
						break;
					}
				}
				if (!check) {
					for (int j = S; j < T; j++) {
						list.get(k)[j] = true;
					}
				}
			}

			list.add(new boolean[1000000000]);

		}
		System.out.println(list.size());
	}
}
