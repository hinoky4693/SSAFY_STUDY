import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박정현_백준_1929_소수구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] arr = new boolean[N+1];
		arr[1] = true;
		for(int idx = 2; idx <= Math.sqrt(N); idx++) {
			for(int i=idx;i<=N/idx;i++) {
				if (idx*i > N) break;
				arr[idx * i] = true;
			}
		}
		
		for(int i=M;i<=N;i++) {
			if(!arr[i]) System.out.println(i);
		}
		
	}
	
}