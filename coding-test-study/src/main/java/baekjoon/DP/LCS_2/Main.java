package baekjoon.DP.LCS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
		char[]         str1 = br.readLine()
			.toCharArray();
		char[]         str2 = br.readLine()
			.toCharArray();

		int[][]        dp   = new int[str1.length + 1][str2.length + 1];
		int            max  = 0;

		for (int i = 1; i < str1.length + 1; i++) {
			for (int j = 1; j < str2.length + 1; j++) {

				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;

				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
//				max = Math.max(max, dp[i][j]);
			}
		}

		int    i      = str1.length;
		int    j      = str2.length;
		String result = "";

		while (i >= 1 && j >= 1) {
			if (dp[i][j] == dp[i - 1][j])
				i--;
			else if (dp[i][j] == dp[i][j - 1])
				j--;
			else {

				result = str2[j - 1] + result;
				i--;
				j--;
			}
		}
		System.out.println(dp[str1.length][str2.length]);
		System.out.println(result);
	}
}