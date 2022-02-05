package baekjoon.그리디.수리공_항승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken()) - 1;

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int cnt = 1;

		if (L == 0) {
			System.out.println(N);
		} else {

			int tmp1 = 0;
			for (int i = 0; i < N; i++) {

				if (i == 0) {
					tmp1 = arr[i] + L;
				}

				if (tmp1 < arr[i]) {
					tmp1 = arr[i] + L;
					cnt++;
				}

			}

			System.out.println(cnt);
		}

	}

}
