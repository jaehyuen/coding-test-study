package baekjoon.DP.타일링;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		int     T  = s.nextInt();

		int[]   dp = new int[T];

		if (T == 1) {
			System.out.println(1);
		} else if (T == 2) {
			System.out.println(2);
		} else {
			dp[0] = 1;
			dp[1] = 2;

			for (int i = 2; i < T; i++) {
				dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
			}

			System.out.println(dp[T - 1]);
		}

	}

}