package baekjoon.DP.Four_Squares;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s  = new Scanner(System.in);
		int     T  = s.nextInt();
		int[]   dp = new int[T + 5];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		for (int i = 4; i <= T; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, dp[i - j * j]);
			}
			dp[i] = min + 1;

		}

		System.out.println(dp[T]);

	}

}
