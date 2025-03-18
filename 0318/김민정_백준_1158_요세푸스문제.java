import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		StringBuilder sb = new StringBuilder("<");
		int cnt = 1;
		while (!queue.isEmpty()) {
			int q = queue.poll();
			if (cnt == K) {
				if (queue.isEmpty()) sb.append(q);
				else sb.append(q + ", ");
				cnt = 0;
			} else {
				queue.add(q);
			}
			cnt++;
		}
		
		System.out.println(sb.append(">"));
	}
}
