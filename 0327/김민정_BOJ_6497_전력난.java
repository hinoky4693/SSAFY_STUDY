import java.io.*;
import java.util.*;

public class BOJ6497_전력난 {

	static int[][] edges;
	static int[] p;

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		while (!(input = br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(input);
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			edges = new int[n][3];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				edges[i][0] = Integer.parseInt(st.nextToken());
				edges[i][1] = Integer.parseInt(st.nextToken());
				edges[i][2] = Integer.parseInt(st.nextToken());
				sum += edges[i][2];
			}

			Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);
			
			p = new int[m+1];
			for (int i = 1; i <= m; i++) {
				p[i] = i;
			}

			int pick = 0;
			int cost = 0;
			for (int[] edge : edges) {
				if (union(edge[0], edge[1])) {
					cost += edge[2];
					if (++pick == m-1) break;
				}
			}
						

			System.out.println(sum - cost);
		}
	}

	static boolean union(int v1, int v2) {
		v1 = findSet(v1);
		v2 = findSet(v2);
		
		if (v1 == v2) return false;
		
		p[v1] = v2;
		return true;
	}

	static int findSet(int v) {
		if (v == p[v]) return v;
		return p[v] = findSet(p[v]);
	}
}
