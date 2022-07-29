package baekjoon.DP.줄어들지_않아;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		long[][] dp = new long[65][10]; // 배열 구성 [자릿수][마지막 숫자]

		for (int i = 1; i < 65; i++) {

			// 0으로 끝나는 자리 세팅
			dp[i][0] = 1;
			
			for (int j = 1; j < 10; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}

		}

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			long result = 0;

			// dp값 전부 더하기
			for (int j = 0; j < 10; j++) {
				result += dp[N][j];
			}
			System.out.println(result);
		}

	}
}