package baekjoon.DP.오르막_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            N  = Integer.parseInt(br.readLine());

		int[][]        dp = new int[N][10];

		dp[0][0] = 1;
		dp[0][1] = 1;
		dp[0][2] = 1;
		dp[0][3] = 1;
		dp[0][4] = 1;
		dp[0][5] = 1;
		dp[0][6] = 1;
		dp[0][7] = 1;
		dp[0][8] = 1;
		dp[0][9] = 1;

		for (int i = 1; i < +N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j] % 10007;
				}

			}
		}

//		for (int[] d : dp) {
//			System.out.println(Arrays.toString(d));
//		}

		int sum = 0;
		for (int i : dp[N - 1]) {
			sum += i % 10007;
		}
		System.out.println(sum % 10007);

	}

}