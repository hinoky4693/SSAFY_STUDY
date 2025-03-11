import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박정현_백준_2805_나무자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		while (st.hasMoreTokens()) {
			trees[idx++] = Integer.parseInt(st.nextToken()); 
		}
//		System.out.println(Arrays.toString(trees));
		
		System.out.println(binarySearch(trees, M));
		
	}

	public static int binarySearch(int[] trees, int M) {
		int left = 0;
		int right = 1000000000;
		int max = Integer.MIN_VALUE;
		long sum = 0;
		while(left <= right) {
			sum = 0;
			int mid = (left + right) / 2;
			for(int i=0;i<trees.length;i++) {
				if (trees[i] - mid > 0) sum += (trees[i] - mid);
			}
			if (sum < M) {
				right = mid - 1;
			} else if (sum >= M) {
				left = mid + 1;
				max = Math.max(max, mid);
				sum = 0;
			}
		}
		
		
		return max;
	}
}
