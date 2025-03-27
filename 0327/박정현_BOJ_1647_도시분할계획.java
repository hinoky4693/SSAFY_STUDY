import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 박정현_BOJ_1647_도시분할계획 {
	
	static class Edge implements Comparable<Edge> {
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

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

	}
	
	static int N, M;
	static int[] p;
	static List<Edge> edges;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		edges = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(edges);
		
		for(int i=1;i<=N;i++) {
			p[i] = i;
		}
		
		int pick = 0;
		int sum = 0;
		
		if(N != 2) {
			for(Edge edge : edges) {
				if(unionSet(edge.s, edge.e)) {
					pick++;
					sum += edge.w;
					if(pick == N-2) break;
				}
			}
		}
		
		System.out.println(sum);
	}
	
	private static int findSet(int v){
		if(v == p[v]) return v;
		return p[v] = findSet(p[v]);
	}
	
	private static boolean unionSet(int v1, int v2){
		v1 = findSet(v1);
		v2 = findSet(v2);
		
		if (v1 == v2) return false;
		p[v1] = v2;
		return true;
	}
}
