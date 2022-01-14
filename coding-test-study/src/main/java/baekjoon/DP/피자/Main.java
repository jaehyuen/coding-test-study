package baekjoon.DP.ÇÇÀÚ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
//		int[] dp = new int[N + 1];
//		dp[0] = 0;
//		
//		for (int i = 1; i <= N; i++) {
//			int a = i / 2;
//			int b = i - a;
//			dp[i] = (a * b) + dp[a] + dp[b];
//		}
		System.out.println(N * (N - 1) / 2);
	}
}
