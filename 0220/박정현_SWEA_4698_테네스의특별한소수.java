import java.util.*;


import java.io.*;

public class 박정현_SWEA_4698_테네스의특별한소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int ans = 0;
			
			
			
			if(D.equals("2")) ans++;
			for(int i=A; i<=B;i++) {
				if (!String.valueOf(i).contains(D)) continue;
				int count = 0;
				for(int j=2;j<i;j++) {
					if(i % j == 0) {
						count++;
						break;
					}
				}
				if (count == 0) {
					String str = String.valueOf(i);
					System.out.println(str);
					if(str.contains(D)) {
						ans++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
}
