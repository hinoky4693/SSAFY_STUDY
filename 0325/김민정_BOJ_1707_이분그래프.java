import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1707_이분그래프 {
	
	static List<Integer>[] list;
	static String ans;
	static boolean[] visited;
	static int[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			ans = "YES";
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				list[b].add(a);
			}
			
			visited = new boolean[V+1];
			check = new int[V+1];
			dfs(1, 1);
			
			for (int i = 1; i <= V; i++) {
				if (!visited[i]) dfs(i, 1);
 			}
			
			System.out.println(ans);
		}
	}

	private static void dfs(int n, int chk) {
		
		check[n] = chk;
		visited[n] = true;
		
		for (int i = 0; i < list[n].size(); i++) {

			if (check[list[n].get(i)] == chk) {
				ans = "NO";
				return;
			}
			
			if (!visited[list[n].get(i)]) {
				dfs(list[n].get(i), 3-chk);
			}
		}
		
	}
}
