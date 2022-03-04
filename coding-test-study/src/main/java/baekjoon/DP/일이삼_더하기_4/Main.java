package baekjoon.DP.일이삼_더하기_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import io.netty.internal.tcnative.Buffer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[][] dp = new int[10001][4];
		
		//1~3까지 초기값 세팅
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			for (int j = 4; j <= N; j++) {
				if (dp[j][1] == 0) {
					
					dp[j][1]=dp[j-1][1];
					dp[j][2]=dp[j-2][1]+dp[j-2][2];
					dp[j][3]=dp[j-3][1]+dp[j-3][2]+dp[j-3][3];

				}

			}
			System.out.println(dp[N][1]+dp[N][2]+dp[N][3]);
		}

	}

}
