package baekjoon.DP.�Ǻ���ġ_�񽺹�����_����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		dp = new long[n + 4];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		System.out.println(likeFibo(n));
	}

	public static long likeFibo(int n) {

		if (dp[n] == 0) {
			dp[n] = likeFibo(n - 1) + likeFibo(n - 3);
		}

		return dp[n];
	}

}
