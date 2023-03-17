package baekjoon.DP.본대_산책;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int D = Integer.parseInt(br.readLine());

		// 디피 선언
		long[][] dp = new long[D + 1][8];

		// 디피 초기화
		dp[0][0] = 1;

		// 0 = 정보섬
		// 1 = 전산관
		// 2 = 미래관
		// 3 = 신양관
		// 4 = 한경직기념관
		// 5 = 진리관
		// 6 = 형남공학관
		// 7 = 학생회관
		for (int i = 0; i < D; i++) {
			// 정보섬
			dp[i + 1][0] = (dp[i][1] + dp[i][2]) % 1000000007;
			// 전산관
			dp[i + 1][1] = (dp[i][0] + dp[i][2] + dp[i][3]) % 1000000007;
			// 미래관
			dp[i + 1][2] = (dp[i][0] + dp[i][1] + dp[i][3] + dp[i][4]) % 1000000007;
			// 신양관
			dp[i + 1][3] = (dp[i][1] + dp[i][2] + dp[i][4] + dp[i][5]) % 1000000007;
			// 한경직기념관
			dp[i + 1][4] = (dp[i][2] + dp[i][3] + dp[i][5] + dp[i][6]) % 1000000007;
			// 진리관
			dp[i + 1][5] = (dp[i][3] + dp[i][4] + dp[i][7]) % 1000000007;
			// 형남공학관
			dp[i + 1][6] = (dp[i][4] + dp[i][7]) % 1000000007;
			// 학생회관
			dp[i + 1][7] = (dp[i][5] + dp[i][6]) % 1000000007;
		}

		System.out.println(dp[D][0]);

	}

}