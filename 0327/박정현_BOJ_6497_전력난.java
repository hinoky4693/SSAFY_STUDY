import java.util.*;
import java.io.*;

public class 박정현_BOJ_6497_전력난 {

	static class Edge implements Comparable<Edge> {
		int s, e, w;
		
		Edge(int s, int e, int w){
			this.s = s;
			this.e = e;
			this.w = w;
		}
	
		public int compareTo(Edge o){
			return this.w - o.w;
		}
	}	
	
	static int m,n;
	static List<Edge> edges; 
	static int[] p;

	public static void main(String[] args) throws IOException {
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		if(m == 0 && n == 0) break;
		edges = new ArrayList<>();
		p = new int[m+1];
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		

		Collections.sort(edges);
		for(int i=1;i<=m;i++){
			p[i] = i;
		}
		
		int pick = 0;
		int sum = 0;

		for(Edge edge : edges){
			sum += edge.w;
		}
		
		for(Edge edge : edges){
			if(unionSet(edge.s, edge.e)) {
				pick++;
				sum -= edge.w;
				if(pick == m-1) break;
			}
		}
		System.out.println(sum);
	}
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