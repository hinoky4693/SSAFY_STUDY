import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박정현_백준_1759_암호만들기 {
	static int L, C;
	static char[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		comb(0, sb);
	}

	private static void comb(int idx, StringBuilder sb) {
		if (sb.length() == L) {
			int count1 = 0;
			int count2 = 0;
			for(int i=0;i<sb.length();i++) {
				if (sb.charAt(i) == 'a' || sb.charAt(i) == 'e' || sb.charAt(i) == 'i'
				 || sb.charAt(i) == 'o' || sb.charAt(i) == 'u' ) {
					count1++;
					if (count2 >= 2) {
						break;
					}
				} else {
					count2++;
					if (count2 >= 2 && count1 >= 1) {
						break;
					}
				}
			}
			if (count1 == 0 || count2 <=1) return;
			else System.out.println(sb);
			return;
		}
		for(int i=idx;i<=C-L+sb.length();i++) {
			sb.append(arr[i]);
			comb(i+1, sb);
			sb.deleteCharAt(sb.length()-1);
		}
		
	}
}