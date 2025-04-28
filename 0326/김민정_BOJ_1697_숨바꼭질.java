import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697_숨바꼭질 {
	
	static int K;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100001];
		System.out.println(bfs(N));
	}

	private static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		
		int cnt = 0;
		
		q.add(n);
		visited[n] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int curr = q.poll();
				
				if (curr == K) return cnt;
				
				if (curr-1 >= 0 && !visited[curr-1]) {
					q.add(curr-1);
					visited[curr-1] = true;
				}
				if (curr+1 <= 100000 && !visited[curr+1]) {
					q.add(curr+1);
					visited[curr+1] = true;
				}
				if (curr*2 <= 100000 && !visited[curr*2]) {
					q.add(curr*2);
					visited[curr*2] = true;
				}
				
			}
			cnt++;
		}
		return -1;
	}
}
