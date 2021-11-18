package baekjoon.DP.LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();

		int size1 = str1.length();
		int size2 = str2.length();
		int[][] dp = new int[size1 + 1][size2 + 1];

		int max = 0;

		for (int i = 1; i <= size1; i++) {
			for (int j = 1; j <= size2; j++) {

				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
//		for (int[] d : dp) {
//			System.out.println(Arrays.toString(d));
//		}
	}

}
