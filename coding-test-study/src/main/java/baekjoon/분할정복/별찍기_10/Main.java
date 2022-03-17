package baekjoon.분할정복.별찍기_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	// 별을 찍을 배열
	static boolean[][] star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		star = new boolean[N][N];

		// 별 찍기
		setting(N, 0, 0);

		// 별로 찍은(true) 만 별로 출력
		for (boolean[] s1 : star) {
			for (boolean s2 : s1) {

				sb.append(s2 ? "*" : " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	public static void setting(int N, int x, int y) {

		// N이 3이 아닐때 (3의 배수일때)
		if (N != 3) {

			// N을 3으로 나눠 준다
			N /= 3;

			// 9분할을 하는데 가운대껀 빼준다
			for (int i = 0; i < N * 3; i += N) {
				for (int j = 0; j < N * 3; j += N) {

					// 가운대껀 뺴주기
					if (j == N && i == N) {
						continue;
					}
					// 재귀
					setting(N, x + i, y + j);

				}
			}

		} else {

			// N이 3일땐 별표 표시를 해준다
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {

					// 가운대껀 뺴주기
					if (j == 1 && i == 1) {
						continue;
					}
					star[x + i][y + j] = true;

				}
			}

		}

	}
}