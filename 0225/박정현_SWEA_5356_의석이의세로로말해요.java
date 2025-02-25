import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박정현_SWEA_5356_의석이의세로로말해요 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			char[][] words = new char[5][];
			sb.append("#"+tc+" ");
			for(int i=0;i<5;i++) {
				char[] temp = br.readLine().toCharArray();
				temp = Arrays.copyOf(temp, 15);
				words[i] = temp;
			}
			for(int j=0;j<15;j++) {
				for(int i=0;i<5;i++) {
					if (words[i][j] != '\u0000') sb.append(words[i][j]);
				}
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}
