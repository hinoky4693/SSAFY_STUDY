import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박정현_SWEA_6485_삼성시의버스노선 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int[] bus = new int[5001];
			int N = Integer.parseInt(br.readLine());
			for(int n=0;n<N;n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken()); 
				
				for(int i=start;i<=end;i++) {
					bus[i]++;
				}
			}

			System.out.print("#"+tc+" ");
			
			int P = Integer.parseInt(br.readLine());
			for(int i=1;i<=P;i++) {
				System.out.print(bus[Integer.parseInt(br.readLine())]+" ");
			}
			System.out.println();
			
			
		}
	}
}
