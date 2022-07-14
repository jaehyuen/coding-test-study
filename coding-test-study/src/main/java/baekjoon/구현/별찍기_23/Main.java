package baekjoon.구현.별찍기_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            N  = Integer.parseInt(br.readLine());

		// 세로 값
		int            M  = 3 + (N - 2) * 2;

		// 가로 값
		int            K  = N * 2 + M - 2;

		arr = new int[M][K];

		for (int i = 0; i < N; i++) {

			// 맨위 아래 별 찍기
			arr[0][i]                       = 1;
			arr[0][K - 1 - i]               = 1;
			arr[M - 1][i]                   = 1;
			arr[M - 1][K - 1 - i]           = 1;

			// 오른쪽 위 별찍기
			arr[i][i]                       = 1;
			arr[i][N - 1 + i]               = 1;

			// 오른쪽 아래 별찍기
			arr[N - 1 + i][N - 1 - i]       = 1;
			arr[N - 1 + i][(2 * N) - 2 - i] = 1;

			// 왼쪽 위 별찍기
			arr[i][K - 1 - i]               = 1;
			arr[i][K - N - i]               = 1;

			// 왼쪽 아래 별찍기
			arr[N - 1 + i][(2 * N) - 2 + i] = 1;
			arr[N - 1 + i][K - N + i]       = 1;

		}

		
		StringBuilder sb2 = new StringBuilder();

		// 별 출력
		for (int[] ar : arr) {
			StringBuilder sb1 = new StringBuilder();
			for (int a : ar) {
				if (a == 1) {
					sb1.append("*");

				} else {
					sb1.append(" ");
				}
			}
			sb2.append(sb1.toString()
				.replaceAll("\\s+$", "") + "\n");

		}

		System.out.println(sb2.toString());
	}

}
