package baekjoon.DP.카드_구매하기_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));

		int             N    = Integer.parseInt(br.readLine());

		int[]           card = new int[N + 1];
		int[]           dp   = new int[N + 1];

		StringTokenizer st   = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			card[i] = Integer.parseInt(st.nextToken());

			dp[i]   = card[i];
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + card[j]);
			}
		}

		System.out.println(dp[N]);

	}

}