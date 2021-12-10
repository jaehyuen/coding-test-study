package baekjoon.DP.일이삼_더하기_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            T  = Integer.parseInt(br.readLine());

//		int[]           arr = new int[N];
		long[][]       dp = new long[100004][4];

		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			for (int j = 4; j <= N; j++) {

				dp[j][1] = (dp[j - 1][3] + dp[j - 1][2]) % 1000000009;
				dp[j][2] = (dp[j - 2][1] + dp[j - 2][3]) % 1000000009;
				dp[j][3] = (dp[j - 3][1] + dp[j - 3][2]) % 1000000009;
			}
			long result = 0;

			for (long tmp : dp[N]) {
				result += tmp;
			}

			System.out.println(result % 1000000009);
		}

	}

}
