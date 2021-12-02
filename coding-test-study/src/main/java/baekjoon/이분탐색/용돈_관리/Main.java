package baekjoon.이분탐색.용돈_관리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             M   = Integer.parseInt(st.nextToken());

		int[]           arr = new int[N];

		// st = new StringTokenizer(br.readLine());

		int             sum = 0;
		int             max = 0;
		for (int i = 0; i < N; i++) {
			arr[i]  = Integer.parseInt(br.readLine());
			sum    += arr[i];
			max     = Math.max(max, arr[i]);
		}

		int start = max;
		int end   = sum;

		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 1;
			for (int i : arr) {
				if (i <= mid) {
					mid -= i;
				} else {
					cnt++;
					mid  = (start + end) / 2;
					mid -= i;
				}
			}

			mid = (start + end) / 2;

			if (cnt <= M)
				end = mid - 1;
			else
				start = mid + 1;
		}

		System.out.println(start);

	}

}
