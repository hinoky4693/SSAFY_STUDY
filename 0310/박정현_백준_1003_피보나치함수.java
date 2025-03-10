import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			List<int[]> list = new ArrayList<>();
			int[] arr = new int[2];
			list.add(new int[] {1,0});
			list.add(new int[] {0,1});
			for(int i=2;i<=N;i++) {
				list.add(new int[] {list.get(i-2)[0] + list.get(i-1)[0], list.get(i-2)[1] + list.get(i-1)[1]});
			}
			
			System.out.println(list.get(N)[0] + " " + list.get(N)[1]);
		}
	}
}
