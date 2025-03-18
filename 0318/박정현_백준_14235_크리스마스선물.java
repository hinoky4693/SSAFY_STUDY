import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 박정현_백준_14235_크리스마스선물 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 0) {
				if(pq.peek() == null) System.out.println(-1);
				else {
					System.out.println(-pq.poll());
				}
			} else {
				while(st.hasMoreTokens()) {
					pq.add(-Integer.parseInt(st.nextToken()));
				}
			}
		}
	}
}
