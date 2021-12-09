package baekjoon.DP.일이삼_더하기_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            T  = Integer.parseInt(br.readLine());

		long[]         dp = new long[1000004];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 0; i < T; i++) {

			int N = Integer.parseInt(br.readLine());

			for (int j = 4; j <= N; j++) {

				if (dp[j] == 0) {
					dp[j] = (dp[j - 2] + dp[j - 1] + dp[j - 3]) % 1000000009;
				}

			}
			System.out.println(dp[N]);
//			System.out.println(Arrays.toString(dp));

		}

//		}
	}

}
