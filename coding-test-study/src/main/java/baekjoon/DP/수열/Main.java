package baekjoon.DP.수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int             N   = Integer.parseInt(br.readLine());
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int[]           arr = new int[N];
		int[]           dp1 = new int[N];
		int[]           dp2 = new int[N];

		int             max = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (i == 0) {
				dp1[i] = 1;
				dp2[i] = 1;
			} else {
				if (arr[i] >= arr[i - 1]) {
					dp1[i] = dp1[i - 1] + 1;
				} else {
					dp1[i] = 1;
				}

				if (arr[i] <= arr[i - 1]) {
					dp2[i] = dp2[i - 1] + 1;
				} else {
					dp2[i] = 1;
				}
			}
			max = Math.max(max, dp1[i]);
			max = Math.max(max, dp2[i]);
		}
		System.out.println(max);

	}

}
