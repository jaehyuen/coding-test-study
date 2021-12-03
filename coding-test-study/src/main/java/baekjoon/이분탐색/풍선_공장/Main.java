package baekjoon.이분탐색.풍선_공장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());

		System.out.println(14L / 5L);

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		long start = 1;
		long end   = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end    = Math.max(end, arr[i]);
		}

		end *= M;

		while (start <= end) {
			long mid = (start + end) / 2;

			long sum = 0;
			for (int i : arr) {
				sum += (mid / i);
			}

//			System.out.println(sum);

			if (sum >= M) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		System.out.println(start);

		// System.out.println("start : " + start + ", end : " + end);

	}

}
