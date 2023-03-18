package baekjoon.DP.제곱수의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {

			// 가장 큰 정수 제곱근 구하기
			int root = (int) Math.sqrt(i);

			if (i == root * root) {
				// 하나의 제곱수로 표현이 가능할떄
				dp[i] = 1;
			} else {
				// 제곱근별 디피 구하기
				dp[i] = i;

				// 현재값보다 작은 제곱수부터 하나씩 체크한다
				for (int j = 2; j * j <= i; j++) {
					dp[i] = Math.min(dp[i], dp[i / (j * j)] + dp[i % (j * j)]);
				}

			}

		}
		System.out.println(dp[N]);

	}
}