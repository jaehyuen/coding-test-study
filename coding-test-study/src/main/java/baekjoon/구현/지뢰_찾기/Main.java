package baekjoon.구현.지뢰_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());

		int[][]        arr = new int[N][N];

		for (int i = 0; i < N; i++) {

			char[] str = br.readLine()
				.toCharArray();

			for (int j = 0; j < N; j++) {
				if (str[j] != '.') {

					// 지뢰표시
					arr[i][j] = -1;

					int cnt = str[j] - '0';

					int x1  = i - 1 < 0 ? 0 : i - 1;
					int y1  = j - 1 < 0 ? 0 : j - 1;

					int x2  = i + 2 > N ? N : i + 2;
					int y2  = j + 2 > N ? N : j + 2;

					// 지뢰값 계산
					for (int a = x1; a < x2; a++) {
						for (int b = y1; b < y2; b++) {

							// 지뢰 자리면 도망감
							if (arr[a][b] == -1)
								continue;

							arr[a][b] += cnt;
						}

					}
				}
			}
		}

		for (int[] ar : arr) {
			for (int a : ar) {
				if (a == -1) {
					System.out.print("*");
				} else if (a > 9) {
					System.out.print("M");
				} else {
					System.out.print(a);
				}

			}
			System.out.println();

		}

	}
}
