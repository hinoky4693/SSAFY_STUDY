import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503_로봇청소기 {

    // 상우하좌
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        int[][] room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r = startR, c = startC, direction = dir;
        int cnt = 0;
        while (true) {
            
            if (room[r][c] == 0) {  // 1번
                room[r][c] = 2;
                cnt++;
                
            }
            
            boolean isClean = true;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;
                if (room[nr][nc] == 0) {
                    isClean = false;
                    break;
                }
            }

            if (!isClean) { // 3번
                
                direction = (direction - 1) < 0 ? 3 : (direction - 1);
                if (room[r + dr[direction]][c + dc[direction]] == 0) {
                    r += dr[direction];
                    c += dc[direction];
//                    System.out.println("chk " + r + " " + c + " " + direction);
                    continue;
                }
//                System.out.println("chk " + r + " " + c + " " + direction);
            } else { // 2번
                int nnr = -2;
                int nnc = -2;
                if (direction == 0) {
                    nnr = r + dr[2];
                    nnc = c + dc[2];
                } else if (direction == 1) {
                    nnr = r + dr[3];
                    nnc = c + dc[3];
                } else if (direction == 2) {
                    nnr = r + dr[0];
                    nnc = c + dc[0];
                } else {
                    nnr = r + dr[1];
                    nnc = c + dc[1];
                }


                if (room[nnr][nnc] == 1) {
                    break;
                }

                r = nnr;
                c = nnc;
            }
        }

        System.out.println(cnt);
    }

}
