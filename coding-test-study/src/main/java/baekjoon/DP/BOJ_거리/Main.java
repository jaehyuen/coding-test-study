package baekjoon.DP.BOJ_거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());
		int[][]        dp  = new int[3][N];

		char[]         arr = br.readLine()
			.toCharArray();
		char[]         boj = { 'B', 'O', 'J' };

		for (int i = 1; i < N; i++) {

			// 인덱스 초기화
			int index = 0;
			if (arr[i] == 'O') {
				index = 1;
			} else if (arr[i] == 'J') {
				index = 2;
			}

			// 초기값 세팅
			dp[index][i] = 1000000;

			for (int j = 0; j < i; j++) {

				// 이전 위치이면 디피 계산
				if (arr[j] == boj[prev(index)]) {
					dp[index][i] = Math.min(dp[index][i], dp[prev(index)][j] + (i - j) * (i - j));
				}
			}
		}

		// 마지막 거리 찾기
		for (int i = 0; i < 3; i++) {
			if (dp[i][N - 1] != 0) {
				System.out.println(dp[i][N - 1] == 1000000 ? -1 : dp[i][N - 1]);
				return;
			}
		}

	}

	// 인덱스 확인 함수
	public static int prev(int index) {

		int prev = index - 1;

		return prev == -1 ? 2 : prev;
	}
}