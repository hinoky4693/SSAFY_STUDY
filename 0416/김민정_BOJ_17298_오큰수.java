//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class BOJ17298_오큰수 {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int N = Integer.parseInt(br.readLine());
//		int[] nums = new int[N];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			nums[i] = Integer.parseInt(st.nextToken());
//		}
//
//		Stack<Integer> stack = new Stack<>();
//		stack.push(nums[N - 1]);
//		StringBuilder sb = new StringBuilder("-1");
//		for (int i = N - 2; i >= 0; i--) {
//			if (stack.isEmpty()) {
//				sb.insert(0, "-1 ");
//				continue;
//			}
//			int n = stack.peek();
//			while (true) {
//				if (nums[i] < n) {
//					sb.insert(0, n + " ");
//					stack.push(nums[i]);
//					break;
//				} else {
//					stack.pop();
//					if (stack.isEmpty()) {
//						sb.insert(0, "-1 ");
//						stack.push(nums[i]);
//						break;
//					}
//					n = stack.peek();
//				}
//			}
//		}
//
//		System.out.println(sb);
//
//	}
//}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298_오큰수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] result = new int[N]; // 결과 저장 배열

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = N - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= nums[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = stack.peek();
			}
			stack.push(nums[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}

