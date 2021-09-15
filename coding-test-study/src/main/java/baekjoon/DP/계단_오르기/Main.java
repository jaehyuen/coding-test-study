package baekjoon.DP.계단_오르기;

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

		if (T == 1) {
			System.out.println(arr[0]);
			return;
		} else if (T == 2) {
			System.out.println(arr[0] + arr[1]);
			return;
		}

		dp[1] = arr[0] + arr[1];
		dp[2] = Math.max(arr[0], arr[1]) + arr[2];

		for (int i = 3; i < T; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
		}
		System.out.println(dp[T - 1]);

	}

}