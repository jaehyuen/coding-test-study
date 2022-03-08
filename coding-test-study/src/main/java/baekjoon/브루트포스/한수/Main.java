package baekjoon.브루트포스.한수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			boolean flag = true;
			// 1~99까진 한수
			if (i >= 100) {

				String[] arr = String.valueOf(i).split("");
				int prev = Integer.parseInt(arr[0]);
				int tmp = -10; // 최대 차수는 -9

				// 등차수열인지 파악
				for (int j = 1; j < arr.length; j++) {
					int now = Integer.parseInt(arr[j]);

					if (tmp == -10) {
						tmp = prev - now;
					} else {
						if (tmp != prev - now) {
							flag = false;
							break;
						}
					}
					prev = now;
				}

			}

			if (flag) {
				cnt++;
			}

		}
		System.out.println(cnt);

	}
}