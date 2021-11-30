package baekjoon.DP.돌_게임_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            N  = Integer.parseInt(br.readLine());

		int[]          dp = new int[N + 5];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 1;
		dp[4] = 1;

		for (int i = 5; i <= N; i++) {

			if (dp[i - 1] + dp[i - 3] + dp[i - 4] < 3)
				dp[i] = 1;
			else
				dp[i] = 0;

		}

		System.out.println(dp[N] == 1 ? "SK" : "CY");

	}

}
