import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 박정현_BOJ_1707_이분그래프 {
	static int V, E;
	static List<Integer>[] arr;
	static boolean[] visited;
	static int[] check;
	static String ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= K; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			arr = new ArrayList[V + 1];
			visited = new boolean[V + 1];
			check = new int[V + 1];

			ans = "YES";
			Arrays.fill(check, 3);

			for (int i = 0; i <= V; i++) {
				arr[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[a].add(b);
				arr[b].add(a);
			}
			for (List<Integer> list : arr) {
				for (int i : list) {
					if (!visited[i]) dfs(i, 0);
				}
			}
			System.out.println(ans);
		}
	}

	private static void dfs(int idx, int val) {
		visited[idx] = true;
		check[idx] = val;
		
		
		
		for (int i = 0; i < arr[idx].size(); i++) {
			int next = arr[idx].get(i);
			if (check[next] == check[idx]) ans = "NO";

			if (!visited[next]) {
				dfs(next, val == 0 ? 1 : 0);
			}
		}
	}
}
