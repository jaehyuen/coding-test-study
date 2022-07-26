package baekjoon.DP.타일_장식물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());
		long[]         dp1 = new long[N + 3];
		long[]         dp2 = new long[N + 3];

		dp1[1] = 1;
		dp1[2] = 2;

		dp2[1] = 4;
		dp2[2] = 10;

		for (int i = 2; i <= N; i++) {
			dp1[i] = dp1[i - 1] + dp1[i - 2];
			dp2[i] = ((dp1[i - 1] + dp1[i]) * 2) + ((dp1[i - 1] + dp1[i - 2]) * 2);
		}
		System.out.println(dp2[N]);

	}
}
