import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박정현_백준_1158_요세푸스문제 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		
		int[] arr = new int[N];
		int idx = 0;
		while (!q.isEmpty()) {
			for(int i=0;i<K-1;i++) {
				int num = q.poll();
				q.add(num);
			}
			arr[idx++] = q.poll();
		}
		System.out.println(Arrays.toString(arr).replace('[', '<').replace(']', '>'));
	}
}
