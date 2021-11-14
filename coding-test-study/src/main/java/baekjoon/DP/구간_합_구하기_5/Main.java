package baekjoon.DP.구간_합_구하기_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][N];
		int[][] dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = 0;
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());

				arr[i][j] = tmp;
				dp[i][j] = tmp + idx;
				idx = dp[i][j];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int fromX = Integer.parseInt(st.nextToken()) - 1;
			int fromY = Integer.parseInt(st.nextToken()) - 1;
			int toX = Integer.parseInt(st.nextToken()) - 1;
			int toY = Integer.parseInt(st.nextToken()) - 1;

			int sum = 0;

			for (int j = fromX; j <= toX; j++) {
				if (fromY == 0) {
					sum += dp[j][toY];
				} else {
					sum += dp[j][toY] - dp[j][fromY - 1];
				}

			}
			sb.append(sum + "\n");

		}

		System.out.println(sb.toString());
//		for (int[] ar : dp) {
//			System.out.println(Arrays.toString(ar));
//		}
	}

}
