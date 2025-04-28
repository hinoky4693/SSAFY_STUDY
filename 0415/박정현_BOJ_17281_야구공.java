import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박정현_BOJ_17281_야구공 {

	static int N;
	static int[][] players;

	static int[] sel;
	static boolean[] visited;
	static int[] temp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		players = new int[N][9];
		sel = new int[9];
		visited = new boolean[10];
		temp = new int[9];
		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				players[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		// 조합 돌려줄게요
		perm(0);

	}

	private static void perm(int sidx) {
		if(sidx == 9) {
			for(int i=0;i<3;i++) {
				temp[i] = sel[i+1];
			}
			for(int i=4;i<9;i++) {
				temp[i] = sel[i];
			}
			temp[3] = sel[0];
			System.out.println(Arrays.toString(temp));
			return;
		}
		
		for(int i=1;i<=9;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			sel[sidx] = i;
			perm(sidx + 1);
			visited[i] = false;
		}
		
	}
}
