package baekjoon.DP.ÇÑ±Û_LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str1 = br.readLine().split("");
		String[] str2 = br.readLine().split("");

		int max = 0;

		int[][] dp = new int[str1.length + 1][str2.length + 1];

		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {

				if (str1[i - 1].equals(str2[j - 1])) {
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
