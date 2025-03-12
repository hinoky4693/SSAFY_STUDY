import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966_프린터큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<Integer[]> queue = new LinkedList<>();
			List<Integer> sorted = new ArrayList<>();
			int target = -1;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				sorted.add(Integer.parseInt(st.nextToken()));
				if (i == M) target = sorted.get(i);
				queue.add(new Integer[] {sorted.get(i), i});
			}
			
			Collections.sort(sorted, Collections.reverseOrder());
			
			
			int cnt = 0;
			while (!queue.isEmpty()) {
				if (queue.peek()[0] == sorted.get(0)) {
					if (sorted.get(0) == target) {
						if (queue.peek()[1] == M) {
							cnt++;
							break;
						} else {
							queue.poll();
							sorted.remove(0);
							cnt++;
						}
					} else {
						queue.poll();
						sorted.remove(0);
						cnt++;
					}
				} else {
					queue.add(queue.peek());
					queue.poll();
				}
			}
			
			
			System.out.println(cnt);
		}
	}
}
