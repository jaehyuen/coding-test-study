package baekjoon.이분탐색.예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));

		int             N   = Integer.parseInt(br.readLine());

		int[]           arr = new int[N];
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int             sum = 0;
		int             max = 0;

		for (int i = 0; i < N; i++) {
			arr[i]  = Integer.parseInt(st.nextToken());

			sum    += arr[i];
			max     = Math.max(max, arr[i]);
		}

		int M = Integer.parseInt(br.readLine());

		if (sum <= M) {
			System.out.println(max);
			return;
		}

		int start = 1;
		int end   = M;
		max = 0;

		while (start <= end) {

			int mid = (start + end) / 2;
			sum = 0;

			for (int a : arr) {
				if (a < mid) {
					sum += a;
				} else {
					sum += mid;
				}
			}

			if (sum > M) {

				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}

		System.out.println(end);

	}

}
