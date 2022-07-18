package baekjoon.구현.경비원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		// 방향 저장 배열
		int[][]         dirArr = { {}, { 4, 3 }, { 3, 4 }, { 1, 2 }, { 2, 1 } };
		BufferedReader  br     = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st     = new StringTokenizer(br.readLine());

		int             row    = Integer.parseInt(st.nextToken());
		int             col    = Integer.parseInt(st.nextToken());

		int             N      = Integer.parseInt(br.readLine());

		int[][]         arr    = new int[N + 1][2];

		// 동근이의 위치와 경비원 위치 입력
		for (int i = 0; i <= N; i++) {
			st        = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

		}

		int result = 0;

		for (int i = 0; i < N; i++) {

			// 동근이와 경비원이 같은 방향이면 둘의 거리를 계산
			if (arr[i][0] == arr[N][0]) {
				result += Math.abs(arr[i][1] - arr[N][1]);
			} else {

				int tmp1 = 0; // 오른쪽으로 돌떄
				int tmp2 = 0; // 왼쪽으로 돌때

				// 오른쪽, 왼쪽 방향에 대해 초기값 설정
				if (arr[N][0] == 1) {
					tmp1 = row - arr[N][1];
					tmp2 = arr[N][1];
				} else if (arr[N][0] == 2) {
					tmp1 = arr[N][1];
					tmp2 = row - arr[N][1];
				} else if (arr[N][0] == 3) {
					tmp1 = arr[N][1];
					tmp2 = col - arr[N][1];
				} else {
					tmp1 = col - arr[N][1];
					tmp2 = arr[N][1];
				}

				// 오른쪽으로 돈다
				int next = dirArr[arr[N][0]][0];
				while (true) {

					if (next == arr[i][0]) {

						if (next == 1) {
							tmp1 += arr[i][1];
						} else if (next == 2) {
							tmp1 += row - arr[i][1];
						} else if (next == 3) {
							tmp1 += col - arr[i][1];
						} else {
							tmp1 += arr[i][1];

						}

						break;
					}

					if (next == 1 || next == 2) {
						tmp1 += row;
					} else {
						tmp1 += col;
					}

					next = dirArr[next][0];

				}

				// 왼쪽으로 돈다
				next = dirArr[arr[N][0]][1];
				while (true) {

					if (next == arr[i][0]) {

						if (next == 1) {
							tmp2 += row - arr[i][1];
						} else if (next == 2) {
							tmp2 += arr[i][1];
						} else if (next == 3) {
							tmp2 += arr[i][1];
						} else {
							tmp2 += col - arr[i][1];

						}

						break;
					}

					if (next == 1 || next == 2) {
						tmp2 += row;
					} else {
						tmp2 += col;
					}

					next = dirArr[next][1];

				}

				// 오른쪽 왼쪽중 최소값을 더함
				result += Math.min(tmp1, tmp2);
			}

		}
		System.out.println(result);
	}

}
