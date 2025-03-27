import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 박정현_BOJ_1197_최소스패닝트리 {

	static class Edge {
		int s, e, w;

		public Edge(int s, int e, int w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", w=" + w + "]";
		}
		
	}
	
	static int[] p;
	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		List<Edge> edges = new ArrayList<>(); 
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(a,b,c));
			
		}

		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.w - o2.w;
			}
		});
		
		long count = 0;
		int pick = 0;
		for(Edge edge : edges) {
			if(unionSet(edge.s, edge.e)) {
				pick++;
				count += edge.w;
				if (pick == V-1) break;
			}
		}
		System.out.println(count);
	}

	private static int findSet(int v) {
		if(v == p[v]) return v;
		return p[v] = findSet(p[v]);
	}
	private static boolean unionSet(int v1, int v2){
		v1 = findSet(v1);
		v2 = findSet(v2);
		
		if(v1 == v2) return false;
		p[v1] = v2;
		return true;
	}
}
