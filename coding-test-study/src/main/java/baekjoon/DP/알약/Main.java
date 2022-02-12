package baekjoon.DP.¾Ë¾à;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static long[] dp = new long[31];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int idx = Integer.parseInt(br.readLine());
			if (idx == 0) {
				break;
			}
			System.out.println(getValue(idx));

		}
	}

	public static long getValue(int n) {
		if (n == 1 || n == 0) {
			return 1;
		} else if (dp[n] != 0) {
			return dp[n];
		} else {
			int idx = n - 1;
			long result = 0;
			for (int i = 0; i < n; i++) {
				result += getValue(i) * getValue(idx);
				idx--;

			}
			dp[n] = result;
			return dp[n];
		}

	}

}
