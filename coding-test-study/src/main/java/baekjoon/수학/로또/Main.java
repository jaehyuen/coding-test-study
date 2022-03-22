package baekjoon.수학.로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 조합을 하기위한 배열
	static int[] arr1;
	static int[] arr2;
	static boolean[] v;

	// 숫자 갯수
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			// 0이 입력되면 종료
			if (N == 0) {
				break;
			}

			// 입력받은 숫자배열
			arr1 = new int[N];

			// 6개 조합을 위한 배열
			arr2 = new int[6];

			// 숫자 입력
			for (int i = 0; i < N; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}

			// 조합
			find(0, 0);

			System.out.println();
		}
	}

	public static void find(int idx, int start) {

		// 조합을 다하면 출력
		if (idx == 6) {
			for (int i : arr2) {
				System.out.print(i + " ");
			}
			System.out.println();

			return;
		}

		// 조합
		for (int i = start; i < N; i++) {

			arr2[idx] = arr1[i];
			find(idx + 1, i + 1);
		}
	}
}