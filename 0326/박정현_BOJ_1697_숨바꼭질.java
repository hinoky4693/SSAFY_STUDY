import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박정현_BOJ_1697_숨바꼭질 {

	static int N, K;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[100001];

		visited[N] = 1;
		bfs();
		System.out.println(visited[K]-1);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);

		while (!q.isEmpty()) {
			int curr = q.poll();
			if (curr == K)
				return;

			if (curr - 1 < visited.length && curr - 1 >= 0 && visited[curr - 1] == 0)  {
				q.add(curr - 1);
				visited[curr - 1] = visited[curr]+1;
			}
			if (curr + 1 < visited.length && curr + 1 >= 0 && visited[curr + 1] == 0) {
				q.add(curr + 1);
				visited[curr + 1] = visited[curr]+1;
			}
			if (curr * 2 < visited.length && curr * 2 >= 0 && visited[curr * 2] == 0) {
				q.add(curr * 2);
				visited[curr * 2] = visited[curr]+1;
			}
		}
	}
}
