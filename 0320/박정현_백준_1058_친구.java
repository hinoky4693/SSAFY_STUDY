import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 박정현_백준_1058_친구 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] arr = new char[N][N];
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		char[][] test = new char[N][N];
		
		int max = 0;
		int count = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if (arr[i][j] == 'Y') {
					test[i][j] = 'Y';
					for(int k=0;k<N;k++) {
						if(arr[j][k] == 'Y') {
							test[i][k] = 'Y';
						}
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j && test[i][j] == 'Y') count++;
			}
			max = Math.max(max, count);
			count = 0;
		}
		System.out.println(max);
	}
}
