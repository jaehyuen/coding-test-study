package baekjoon.DP.다이나믹이_뭐예요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st   = new StringTokenizer(br.readLine());

		int             n    = Integer.parseInt(st.nextToken());
		int             m    = Integer.parseInt(st.nextToken());

		int[][]         dp   = new int[n + 1][m + 1];

		int[]           xArr = { -1, 0, -1 };
		int[]           yArr = { 0, -1, -1 };

		dp[1][1] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				for (int k = 0; k < 3; k++) {
					int tmpX = i + xArr[k];
					int tmpY = j + yArr[k];

					if (tmpX < 1 || tmpY < 1)
						continue;

					dp[i][j] = (dp[i][j] + dp[tmpX][tmpY]) % 1000000007;
				}

			}
		}

		System.out.println(dp[n][m]);

	}

}
