package baekjoon.구현.인기_투표;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int   N   = Integer.parseInt(br.readLine());
			int   sum = 0;
			int   max = 0;

			int[] arr = new int[N];

			for (int j = 0; j < N; j++) {

				arr[j]  = Integer.parseInt(br.readLine());
				sum    += arr[j];
				max     = Math.max(max, arr[j]);

			}

			int cnt = 0;
			int idx = 0;

			// 승자 여러명인지 체크
			for (int j = 0; j < N; j++) {

				if (arr[j] == max) {
					cnt++;
					idx = j;
				}

			}

			if (cnt > 1) {
				System.out.println("no winner");
			} else if (max > sum / 2) {
				System.out.println("majority winner " + (idx + 1));
			} else {
				System.out.println("minority winner " + (idx + 1));
			}
		}
	}
}
