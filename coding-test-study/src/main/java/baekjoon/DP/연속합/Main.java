package baekjoon.DP.연속합;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s   = new Scanner(System.in);
		int     T   = s.nextInt();
		int[]   arr = new int[T];
		int[]   dp  = new int[T];

		for (int i = 0; i < T; i++) {
			arr[i] = s.nextInt();
		}

		dp[0] = arr[0];
		for (int i = 1; i < T; i++) {

			dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);

		}
		Arrays.sort(dp);

		System.out.println(dp[T - 1]);
	}

}
