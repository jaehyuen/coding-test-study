package baekjoon.DP.상자넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int             n   = Integer.parseInt(br.readLine());

		StringTokenizer st  = new StringTokenizer(br.readLine());

		int[]           arr = new int[n];
		int[]           dp  = new int[n];

//		for (int i = 0; i < n; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}

//		dp[0] = 1;
//
//		int max = dp[0];
//
//		for (int i = 1; i < n; i++) {
//			dp[i] = 1;
//
//			for (int j = 0; j < i; j++) {
//				if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
//					dp[i] = dp[j] + 1;
//				}
//			}
//			max = Math.max(max, dp[i]);
//
//		}
//
//		System.out.println(max);

		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(-1);

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (test.get(test.size() - 1) < arr[i]) {
				test.add(arr[i]);
			} else {
				int start = 0;
				int end   = test.size() - 1;

				while (start < end) {
					int mid = (start + end) / 2;

					if (arr[i] <= test.get(mid)) {

						end = mid;
					} else {
						start = mid + 1;

					}
				}
				test.set(end, arr[i]);

			}

		}
		System.out.println(test.size() - 1);

	}

}
