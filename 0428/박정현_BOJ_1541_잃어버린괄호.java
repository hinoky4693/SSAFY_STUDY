import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 박정현_BOJ_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		List<String> numList = new ArrayList<>();
		List<Character> pmList = new ArrayList<>();
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '+' || line.charAt(i) == '-') {
				numList.add(sb.toString());
				sb.setLength(0);
				pmList.add(line.charAt(i));
			}
			else {
				sb.append(line.charAt(i));
			}
		}
		numList.add(sb.toString());
		
		int idx = 0;
		int sum = Integer.parseInt(numList.get(0));
		boolean check = false;
		for(int i=1;i<numList.size();i++) {
			if (pmList.get(idx) == '+' && !check) {
				sum += Integer.parseInt(numList.get(i));
			} else if(pmList.get(idx) == '+' && check) {
				sum -= Integer.parseInt(numList.get(i));
			} else if(pmList.get(idx) == '-') {
				sum -= Integer.parseInt(numList.get(i));
				check = true;
			}
			idx++;
		}
		System.out.println(sum);
	}
}
