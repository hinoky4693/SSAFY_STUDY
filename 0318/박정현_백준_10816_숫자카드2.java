import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 박정현_백준_10816_숫자카드2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()), 0)+" ");
		}
		System.out.println(sb);
	}
}