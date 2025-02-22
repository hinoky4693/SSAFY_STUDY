import java.util.Scanner;

public class Q7964 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 도시의 수
			int D = sc.nextInt(); // 이동 제한 거리
			int[] arr = new int[N];

			// 도시별 차원관문 정보 입력
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int count = 0; // 새로 설치할 차원관문 수
			for (int i = 0; i < N; i++) { // 도시들을 순차적으로 확인
				if (arr[i] == 0) {// 차원관문이 파괴된 도시에서만 작업
					boolean foundPortal = false; //i부터 D거래 내에 차원관문 있는지 확인
					for (int j = 1; j <= D && i + j < N; j++) {
						if (arr[i + j] == 1) {
							foundPortal = true;
							break;
						}
					}

					if (!foundPortal) { // 차원관문이 없으면 설치
						arr[i] = 1; // 차원관문 설치
						count++; // 설치 개수 증가
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}
}
