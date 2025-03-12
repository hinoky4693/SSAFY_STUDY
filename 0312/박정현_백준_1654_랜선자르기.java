import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박정현_백준_1654_랜선자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K];
		for(int i=0;i<K;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} // 랜선 길이 입력 완료
//		System.out.println(Arrays.toString(arr));
		
		System.out.println(binarySearch(arr, K, N));
	}

	private static long binarySearch(int[] arr, int k, int n) {
		long left = 1;
		long right = (1<<31)-1;
		long ans = 0;
		while(left <= right) {
			long count = 0;
			long mid = (left + right) / 2;
			
			for(int i=0;i<k;i++) {
				int temp = arr[i];
				
				while(temp >= mid) {
					count++;
					temp -= mid;
				}
			}
			
			if (count < n) {
				right = mid - 1;
			} else {
				ans = mid;
				left = mid + 1;
			}
		}
		
		return ans;
	}
	
	
}
