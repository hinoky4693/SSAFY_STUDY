import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1197_최소스패닝트리 {
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static Edge[] edges;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		

		edges = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edges[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edges);

		p = new int[V+1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		int pick = 0;
		int cost = 0;
		for (Edge edge : edges) {
			if (unionSet(edge.from, edge.to)) {
				cost += edge.weight;
				if (++pick == V-1) break;
			}
		}

		System.out.println(cost);
	}

	private static boolean unionSet(int from, int to) {
		from = findSet(from);
		to = findSet(to);
		
		if (from == to) return false;
		
		p[from] = to;
		return true;
	}

	private static int findSet(int v) {
		if (p[v] == v) return v;
		return p[v] = findSet(p[v]);
	}
}
