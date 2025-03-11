import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[N];
		int minHeight = 0;
		int maxHeight = 1000000000;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
//			if (trees[i] < minHeight) minHeight = trees[i];
//			if (trees[i] > maxHeight) maxHeight = trees[i];
		}
		
		int ans = Integer.MIN_VALUE;
		int cutHeight = -1;
		while (minHeight <= maxHeight) {
//			if (cutHeight == (minHeight + maxHeight) / 2) break;
			long sum = 0;
			cutHeight = (minHeight + maxHeight) / 2;
			for (int i = 0; i < N; i++) {
				sum += trees[i] >= cutHeight ? trees[i] - cutHeight : 0;
			}
			
			if (sum >= M) {
				minHeight = cutHeight+1;
				ans = Math.max(cutHeight, ans);
			} else {
				maxHeight = cutHeight-1;
			}
		}
		System.out.println(ans);
	}
}
