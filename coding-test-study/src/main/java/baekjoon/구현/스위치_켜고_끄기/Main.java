package baekjoon.구현.스위치_켜고_끄기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[] test;

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int             N  = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean[]       v  = new boolean[N];

		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			if (tmp == 1) {
				v[i] = true;
			}
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int gen = Integer.parseInt(st.nextToken());
			int tmp = Integer.parseInt(st.nextToken());

			if (gen == 1) {
				// 배수로 변경
				for (int j = tmp - 1; j < N; j += tmp) {
					v[j] = !v[j];
				}
			} else {

				// 감소
				tmp--;

				// 본인위치 변경
				v[tmp] = !v[tmp];

				// 양쪽 초기값 설정
				int l = tmp - 1;
				int r = tmp + 1;

				while (true) {

					// 범위 체크
					if (l < 0 || r >= N) {
						break;
					}

					// 값 체크
					if (v[l] != v[r]) {
						break;
					}

					v[l] = !v[l];
					v[r] = !v[r];

					l--;
					r++;

				}
			}

		}

		int cnt = 0;
		for (boolean b : v) {
			cnt++;
			System.out.print((b ? 1 : 0) + " ");

			// 20개마다 줄바꿈
			if (cnt % 20 == 0) {
				System.out.println();
			}
		}

	}

}
