package baekjoon.DP.가장_큰_증가_부분_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int             A   = Integer.parseInt(br.readLine());
		int[]           arr = new int[A];
		int[]           dp  = new int[A];

		StringTokenizer st  = new StringTokenizer(br.readLine());

		for (int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;

		dp[0] = 1;
		for (int i = 0; i < A; i++) {
			dp[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[j] + arr[i]> dp[i]) {
					dp[i] = dp[j] + arr[i];
				}
			}
			max = Math.max(max, dp[i]);
		}
		//System.out.println(Arrays.toString(dp));
		System.out.println(max);

	}

}
