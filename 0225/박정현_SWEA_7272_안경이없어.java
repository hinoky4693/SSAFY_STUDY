import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 박정현_SWEA_7272_안경이없어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Character, Character> alphabets = new HashMap<>();
		alphabets.put('A', '1'); alphabets.put('B', '2'); alphabets.put('C', '0');
		alphabets.put('D', '1'); alphabets.put('E', '0'); alphabets.put('F', '0');
		alphabets.put('G', '0'); alphabets.put('H', '0'); alphabets.put('I', '0');
		alphabets.put('J', '0'); alphabets.put('K', '0'); alphabets.put('L', '0');
		alphabets.put('M', '0'); alphabets.put('N', '0'); alphabets.put('O', '1');
		alphabets.put('P', '1'); alphabets.put('Q', '1'); alphabets.put('R', '1');
		alphabets.put('S', '0'); alphabets.put('T', '0'); alphabets.put('U', '0');
		alphabets.put('V', '0'); alphabets.put('W', '0'); alphabets.put('X', '0');
		alphabets.put('Y', '0'); alphabets.put('Z', '0');
		
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String left = st.nextToken();
			String right = st.nextToken();
			
			String leftTemp = null;
			String rightTemp = null;
			
			for(int i=0;i<left.length();i++) {
				leftTemp += alphabets.get(left.charAt(i));
			}
			for(int i=0;i<right.length();i++) {
				rightTemp += alphabets.get(right.charAt(i));
			}
			
			if (leftTemp.equals(rightTemp)) System.out.println("#"+tc+" SAME");
			else System.out.println("#"+tc+" DIFF");
		}
	}
}
