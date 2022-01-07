package baekjoon.이분탐색.과자_나눠주기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[M];

		st = new StringTokenizer(br.readLine());

		int end = 0;
		int start = 1;

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, arr[i]);
		}

		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 0;
			for (int i : arr) {
				cnt += i / mid;
			}

			if (cnt >= N) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(end);

	}

}
