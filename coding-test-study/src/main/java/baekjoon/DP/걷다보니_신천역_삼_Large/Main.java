package baekjoon.DP.걷다보니_신천역_삼_Large;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 점화식의 결과가 int형을 넘어가기에 long으로 선언
		long[] dp = new long[N + 4];
		dp[2] = 2;

		// 이전 자리수에 3을 곱하면 현재 자리수에서 만들수잇는 3의 배소 갯수를 구할수있다
		for (int i = 3; i < dp.length; i++) {
			dp[i] = (dp[i - 1] * 3) % 1000000009;
		}
		System.out.println(dp[N]);
	}
}