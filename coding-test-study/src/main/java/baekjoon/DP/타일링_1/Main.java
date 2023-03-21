package baekjoon.DP.타일링_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		// dp 배열 선언
		BigInteger[] dp = new BigInteger[251];

		// 0도 1가지 방법이다
		dp[0] = new BigInteger("0");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");

		// dp[i] = (dp[i - 2] * 2) + dp[i - 1]
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i - 2].multiply(new BigInteger("2")).add(dp[i - 1]);
		}
		// System.out.println(Arrays.toString(dp));
		while (input != null) {
			System.out.println(dp[Integer.parseInt(input)].toString());
			input = br.readLine();
		}

	}

}