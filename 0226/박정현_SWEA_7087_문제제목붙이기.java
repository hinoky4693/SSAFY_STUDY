import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박정현_SWEA_7087_문제제목붙이기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean[] alphabets = new boolean[26];
			for(int i=0;i<N;i++) {
				alphabets[br.readLine().charAt(0)-'A'] = true;
			}
			int answer = 0;
			for(int i=0;i<alphabets.length;i++) {
				if (alphabets[i] != true) {
					System.out.println("#"+tc+" "+answer);
					break;
				}
				else if(i == 25) {
					answer ++;
					System.out.println("#"+tc+" "+answer);
					break;
				}
				else answer++;
			}
		}
		
	}
}
