import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 박정현_BOJ_1931_회의실배정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1]-o2[1];
            return o1[0] - o2[0];
        });
        
//        System.out.println(Arrays.deepToString(arr));
        
        List<int[]> list = new ArrayList<>();
        int tmp = -1;
        boolean check = false;
        for (int[] a : arr) {
            if (a[0] == tmp && check) {
                list.add(a);
                check = false;
            } else if (a[0] != tmp) {
                tmp = a[0];
                list.add(a);
            }
            if (a[0] == a[1]) check = true;
        }
        
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(Arrays.toString(list.get(i)));
//        }
        
        Stack<int[]> stack = new Stack<>();
        stack.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            int[] prev = stack.peek();
            int[] curr = list.get(i);
            if (prev[1] <= curr[0]) {
                stack.add(curr);
            } else if (prev[1] > curr[1]) {
                stack.pop();
                stack.add(curr);
            }
        }
        System.out.println(stack.size());
    }
    
}