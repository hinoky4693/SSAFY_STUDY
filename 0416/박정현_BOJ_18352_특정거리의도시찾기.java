import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박정현_BOJ_18352_특정거리의도시찾기 {

	static List<Integer>[] listArr;
	static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		listArr = new ArrayList[N + 1];
		map = new int[N + 1];
		Arrays.fill(map, -1);
		for (int i = 0; i <= N; i++) {
			listArr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			listArr[a].add(b);
		}

		bfs(X);
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		for(int i = 0; i<map.length;i++) {
			if (map[i] == K) {
				sb.append(i).append("\n");
			}
		}
		
		if (sb.isEmpty()) System.out.println(-1);
		else System.out.println(sb);
	}

	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		map[x] = 0;
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			count++;
			for (int i = 0; i < size; i++) {
				int curr = q.poll();
				for (int j : listArr[curr]) {
					if (map[j] != -1) continue;
					q.add(j);
					map[j] = count;
				}
			}
		}
	}
}
