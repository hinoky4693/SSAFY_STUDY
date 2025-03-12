import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박정현_백준_1966_프린터큐 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// 입력 끝
			
			
			Queue<int[]> queue = new LinkedList<>();
			int[] scores = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int[] arr = new int[2];
				arr[0] = i;
				arr[1] = Integer.parseInt(st.nextToken());
				scores[i] = arr[1];
				queue.add(arr);
			}
			
			
			int count = 1;
			
			Arrays.sort(scores);
			int idx = scores.length-1;
					
			
			while(!queue.isEmpty()) {
				int[] temp = queue.poll();

				if (temp[1] == scores[idx]) {
					if(temp[0] == M) {
						System.out.println(count);
						break;
					} else {
						count++;
						idx--;
					}
				}
				
				else {
					queue.add(temp);
				}
				
				
			}
			
			
		} // tc
	}
}
