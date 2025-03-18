import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14235_크리스마스선물 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 0) {
				if (pq.isEmpty()) {
					System.out.println(-1);
					continue;
				} else {
					System.out.println(pq.poll());
					continue;
				}
			} else {
				for (int j = 0; j < a; j++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
	}
}
