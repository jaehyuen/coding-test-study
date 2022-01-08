package baekjoon.이분탐색.보석_상자;

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

		int[] gem = new int[M];

		int start = 1;
		int end = 0;
		for (int i = 0; i < M; i++) {
			gem[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, gem[i]);
		}

		while (start <= end) {

			int mid = (start + end) / 2;
			int cnt = 0;

			for (int i : gem) {
				cnt += (int) Math.ceil(i / (double) mid);
			}

			if (cnt > N) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		System.out.println(start);
	}

}
