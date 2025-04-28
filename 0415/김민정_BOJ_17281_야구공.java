//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BOJ17281_야구공 {
//
//	static int[][] res;
//	static int[] sel;
//	static boolean[] visited;
//	static Queue<Integer> base;
//	static int N, outNum, max;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		N = Integer.parseInt(br.readLine());
//		res = new int[N][9];
//		for (int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < 9; j++) {
//				res[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		sel = new int[8];
//		visited = new boolean[9];
//		max = Integer.MIN_VALUE;
//		perm(0);
//
//		System.out.println(max);
//	}
//
//	private static void perm(int idx) {
//		if (idx == 8) {
////			System.out.println(Arrays.toString(sel));
//			List<Integer> finSel = new ArrayList<>();
//			for (int i = 0; i < 8; i++) {
//				finSel.add(sel[i]);
//			}
//			finSel.add(3, 0);
//
//			base = new LinkedList<>();
////			Arrays.fill(base, -1);
//			outNum = 0;
////			calScore(finSel);
//			max = Math.max(max, calScore(finSel));
//			return;
//		}
//		for (int i = 1; i < 9; i++) {
//			if (visited[i])
//				continue;
//			visited[i] = true;
//			sel[idx] = i;
//			perm(idx + 1);
//			visited[i] = false;
//		}
//	}
//
//	private static int calScore(List<Integer> sel) {
////		System.out.println(sel);
//		int idx = 0;
//		int sum = 0;
//
//		for (int i = 0; i < N; i++) {
//			while (outNum < 3) {
//
//				int sc = res[i][sel.get(0)];
//
//				if (sc == 0) {
//					outNum++;
//					int tmp = sel.get(0);
//					sel.add(tmp);
//					sel.remove(0);
//				} else if (sc == 4) {
//					int tmp = sel.get(0);
//					sel.add(tmp);
//					sel.remove(0);
//					sum += base.size() + 1;
//					base.clear();
//				} else {
//					base.add(sc);
//					int t = 0;
//					for (int s : base) {
//						t += s;
//					}
//					while (t >= 4) {
//						t -= base.poll();
//						sum++;
//					}
//					int tmp = sel.get(0);
//					sel.add(tmp);
//					sel.remove(0);
//				}
//
//				if (outNum == 3) {
//					base.clear();
//					outNum = 0;
//					break;
//				}
//
//			}
//		}
//		return sum;
//	}
//
//}
import java.io.*;
import java.util.*;

public class BOJ17281_야구공 {

    static int[][] result;
    static boolean[] visited = new boolean[9];
    static int[] order = new int[9];
    static int N, maxScore = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N][9];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        order[3] = 0;  // 4번 타자는 항상 1번 선수
        perm(0);
        System.out.println(maxScore);
    }

    static void perm(int idx) {
        if (idx == 9) {
            maxScore = Math.max(maxScore, getScore());
            return;
        }

        if (idx == 3) {
            perm(idx + 1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[idx] = i;
                perm(idx + 1);
                visited[i] = false;
            }
        }
    }

    static int getScore() {
        int score = 0;
        int batterIdx = 0;

        for (int inning = 0; inning < N; inning++) {
            int out = 0;
            boolean[] base = new boolean[3];

            while (out < 3) {
                int hitter = order[batterIdx % 9];
                int play = result[inning][hitter];
                batterIdx++;

                if (play == 0) {
                    out++;
                } else if (play == 1) {
                    if (base[2]) score++;
                    base[2] = base[1];
                    base[1] = base[0];
                    base[0] = true;
                } else if (play == 2) {
                    if (base[2]) score++;
                    if (base[1]) score++;
                    base[2] = base[0];
                    base[1] = true;
                    base[0] = false;
                } else if (play == 3) {
                    for (int i = 0; i < 3; i++) {
                        if (base[i]) score++;
                        base[i] = false;
                    }
                    base[2] = true;
                } else { // 홈런
                    for (int i = 0; i < 3; i++) {
                        if (base[i]) score++;
                        base[i] = false;
                    }
                    score++;
                }
            }
        }

        return score;
    }
}
