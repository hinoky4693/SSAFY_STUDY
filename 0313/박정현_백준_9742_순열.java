import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 박정현_백준_9742_순열 {
	
	static int N, R, order;
	static char[] wordArr;
	static char[] sel;
	static boolean[] visited;
	static List<char[]> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = br.readLine()) != null) {
			if(input.isEmpty()) break;
			StringTokenizer st = new StringTokenizer(input);
			
			
			String word = st.nextToken();
			
			R = N = word.length();
			
			wordArr = new char[N];
			wordArr = word.toCharArray();

			sel = new char[N];
			
			visited = new boolean[N];
			
			order = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			
			comb(0,0);
			
			perm(0);
			
			StringBuilder sb = new StringBuilder();
			if(order > list.size()) {
				sb.setLength(0);
				sb.append("No permutation");
			} else {
				for(int i=0;i<N;i++) {
					sb.append(list.get(order-1)[i]);
				}
			}
			
			System.out.println(word+" "+order+" = "+sb);
			
		}
		
		
		
		
	}

	private static void comb(int idx, int sidx) {
		//종료 조건
		if(sidx == R) {
			System.out.println(Arrays.toString(sel));
			list.add(sel.clone());
			return;
		}
		
		//재귀 조건
		for(int i=idx;i<N-R-sidx;i++) {
			sel[sidx] = wordArr[i];
			comb(i+1, sidx+1);
		}
	}
	
	private static void perm(int idx) {
		//종료 조건
		if(idx == N) {
			list.add(sel.clone());
			return;
		}
		
		//재귀 조건
		for(int i=0;i<N;i++) {
			if (visited[i]) continue;
			sel[idx] = wordArr[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
	}
	
}
