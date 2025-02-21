import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박정현_SWEA_7964_부먹왕국의차원관문 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스
		for(int tc = 1; tc <= T; tc++) {			// 테케 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());	// 도시 수
			int D = Integer.parseInt(st.nextToken());	// 제한 거리
			st = new StringTokenizer(br.readLine());	// 지도 정보
			int[] cities = new int[N];					// 지도 배열
			for(int i=0;i<N;i++) {
				cities[i] = Integer.parseInt(st.nextToken());	// 지도 정보 배열에 담기
			}
			
			int count = 1;
			int ans = 0;
			for(int i = 0; i< N; i++) {
				if (cities[i] == 0) {
					if (count == D) {
						ans++;
						count = 1;
					}
					else count++;
				} else {
					count = 1;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
