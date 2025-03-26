
public class 박정현_백준_4673_셀프넘버 {
	static boolean[] visited;
	public static void main(String[] args) {
		visited = new boolean[10001];
		visited[0] = true;
		for(int i=1;i<=10000;i++) {
			func(i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<visited.length;i++) {
			if(!visited[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	private static void func(int i) {
		String temp = String.valueOf(i);
		for(int j=0;j<temp.length();j++) {
			i += (temp.charAt(j)-'0');
		}
		if (i>10000) return;
		
		if (!visited[i]) {
			visited[i] = true;
		}
		func(i);
	}
}
