import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 박정현_BOJ_17298_오큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append(" 1-");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			list.add(n);
		}
		Stack<Integer> stack = new Stack<>();
		stack.add(list.get(list.size() - 1));

		for (int i = list.size() - 2; i >= 0; i--) {
			while (!stack.empty() && stack.peek() <= list.get(i))
				stack.pop();
			if (stack.empty()) {
				sb.append(" 1-");
				stack.add(list.get(i));
			} else if (stack.peek() > list.get(i)) {
				StringBuilder str = new StringBuilder();
				str.append(stack.peek());
				sb.append(" ").append(str.reverse());
				stack.add(list.get(i));
			}
		}
		System.out.println(sb.reverse());
	}
}
