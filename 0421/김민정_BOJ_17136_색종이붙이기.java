//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class BOJ17136_색종이붙이기 {
//	
//	static int[][] map, cnt;
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		map = new int[10][10];
//		for (int i = 0; i < 10; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < 10; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		cnt = new int[10][10];
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				if (map[i][j] == 1) {
//					count(i, j);
//				}
//			}
// 		}
//		
//		for (int i = 0; i < 10; i++) {
//			System.out.println(Arrays.toString(cnt[i]));
//		}
//		
//		boolean[][] visited = new boolean[10][10];
//		
//		int ans = 0;
//		for (int n = 5; n > 0; n--) {
//			int c = 5;
//			outer:for (int i = 0; i < 10; i++) {
//				for (int j = 0; j < 10; j++) {
//					if (cnt[i][j] == n && !visited[i][j]) {
//						ans++; c--;
//						for (int ii = i; ii < i + n; ii++) {
//							for (int jj = j; jj < j + n; jj++) {
//								visited[ii][jj] = true;
//								cnt[ii][jj] = n;
//							}
//						}
//						if (c == 0) break outer;
//					}
//				}
//			}
//			
//		}
//		
//		System.out.println(ans);
//	}
//	 
//	private static void count(int r, int c, int[] cntt, boolean[][] visited) {
//		
//		int nn = -1;
//		for (int n = 5; n > 0; n--) {
//			boolean isOk = true;
//			outt:for (int i = r; i < r + n; i++) {
//				for (int j = c; j < c + n; j++) {
//					if (i >= 10 || j >= 10 || map[i][j] == 0) {
//						isOk = false;
//						break outt;
//					}
//				}
//			}
//			if (isOk) {
//				nn = n;
////				cnt[r][c] = n;
//				break;
//			}
//		}
//		
//		for (int n = nn; n > 0; n--) {
//			for (int i = r; i < r + nn; i++) {
//				for (int j = c; j < c + nn; j++) {
//					visited[i][j] = true;
//				}
//			}
//			cntt[n]--;
//			if (cntt[n] == 0) return;
//			count(r+n, c+n, cntt, visited);
//		}
//		
//	}	
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17136_색종이붙이기 {
    static int[][] map = new int[10][10];
    static int[] paper = { 0, 5, 5, 5, 5, 5 }; // 1~5 크기 색종이 각 5장
    static int min = Integer.MAX_VALUE;

    public static void dfs(int r, int c, int used) {
        if (r >= 10) {
            min = Math.min(min, used);
            return;
        }

        if (c >= 10) {
            dfs(r + 1, 0, used);
            return;
        }

        if (map[r][c] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (canAttach(r, c, size) && paper[size] > 0) {
                    attach(r, c, size, 0); // 붙이기
                    paper[size]--;
                    dfs(r, c + 1, used + 1);
                    attach(r, c, size, 1); // 복구
                    paper[size]++;
                }
            }
        } else {
            dfs(r, c + 1, used);
        }
    }

    static boolean canAttach(int r, int c, int size) {
        if (r + size > 10 || c + size > 10)
            return false;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

    static void attach(int r, int c, int size, int val) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                map[i][j] = val;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        dfs(0, 0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}