import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18352_특정거리의도시찾기 {
	
	static int N, K;
	static List<Integer>[] adj;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adj[s].add(e);
		}
		
		List<Integer> ans = bfs(X);
		
		int size = ans.size();
		if (size == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(ans);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < size; i++) {
				sb.append(ans.get(i) + "\n");
			}
			System.out.println(sb);
		}
	}

	private static List<Integer> bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[N+1];
		Arrays.fill(visited, -1);
		q.add(start);
		visited[start] = 0;
		
		int cnt = 0;
		while (!q.isEmpty()) {
			
			if (cnt > K) {
				break;
			}
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int curr = q.poll();
				
				for (int n : adj[curr]) {
					if (visited[n] == -1) {
						visited[n] = visited[curr]+1;
						q.add(n);
					}
				}
			}
			cnt++;
		}
		
		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (visited[i] == K) {
				ans.add(i);
			}
		}
		
		return ans;
	}
}
