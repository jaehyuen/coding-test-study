package baekjoon.DP.피보나치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BigInteger[] fibo = new BigInteger[10001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		fibo[0] = new BigInteger("1");
		fibo[1] = new BigInteger("1");

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());

			System.out.println("Case #" + (i + 1) + ": " + (getFibo(P - 1).remainder(new BigInteger(st.nextToken()))));

		}
	}

	public static BigInteger getFibo(int n) {
		if (n < 2) {
			return new BigInteger("1");
		} else if (fibo[n] == null) {
			fibo[n] = getFibo(n - 1).add(getFibo(n - 2));

			return fibo[n];
		} else {
			return fibo[n];
		}
	}

}
