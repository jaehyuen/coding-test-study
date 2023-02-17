package baekjoon.그리디.그렇고_그런_사이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             K   = Integer.parseInt(st.nextToken());

		int[]           arr = new int[N];

		// 순서 초기화
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		// 마지막 위치(큰 숫자부터 움직임)
		int idx = N - 1;

		// 왼쪽 자리 고정 임시값
		int tmp = 0;

		for (int i = 0; i < K; i++) {

			// 위치 초기화
			if (idx - tmp == 0) {
				idx = N - 1;
				tmp++;
			}

			int swap = arr[idx];
			arr[idx]     = arr[idx - 1];
			arr[idx - 1] = swap;

			idx--;

		}

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
