package baekjoon.DP.악수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// dp 초기화
		int[] dp = new int[N + 2];
		dp[1] = 1;
		dp[2] = 2;

		// dp 계산과 마지막 자리만 출력하기 위해 10으로 나눈 나머지를 저장
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 10;
		}
		System.out.println(dp[N]);

	}

}
