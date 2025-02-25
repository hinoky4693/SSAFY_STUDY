import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박정현_SWEA_1940_가랏RC카 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int speed = 0;
			int distance = 0;
			int N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				if (command == 1) {
					speed += Integer.parseInt(st.nextToken());
					distance += speed;
				} else if(command == 2) {
					speed -= Integer.parseInt(st.nextToken());
					if (speed < 0) speed = 0;
					distance += speed;
				} else {
					distance += speed;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(distance);
			System.out.println(sb);
		}
	}
}
