package baekjoon.DP.과일_서리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static BigInteger[] dp = new BigInteger[30];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		// 종류 갯수와 훔칠 갯수가 같으면 1가지 방법
		if (N == M) {
			System.out.println("1");
			return;
		}

		// 중복 조합 공식
		// (종류갯수 + 조합갯수 - 1)! / 조합갯수! * 종류 갯수!
		BigInteger tmp1 = find(BigInteger.valueOf(M - 1));
		BigInteger tmp2 = find(BigInteger.valueOf(M - N));
		BigInteger tmp3 = find(BigInteger.valueOf(N - 1));

		System.out.println(tmp1.divide(tmp2.multiply(tmp3)));
	}

	public static BigInteger find(BigInteger n) {
		if (dp[n.intValue()] != null) {
			return dp[n.intValue()];
		}
		if (n.equals(BigInteger.ONE) || n.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		} else {
			dp[n.intValue()] = find(n.subtract(BigInteger.ONE)).multiply(n);
			return dp[n.intValue()];
		}
	}
}