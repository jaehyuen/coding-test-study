package baekjoon.구현.행사장_대여;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());

		int[][]        map = new int[501][501];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 좌측 하단
			int             x1 = Integer.parseInt(st.nextToken());
			int             y1 = Integer.parseInt(st.nextToken());

			// 우측 상단
			int             x2 = Integer.parseInt(st.nextToken());
			int             y2 = Integer.parseInt(st.nextToken());

			for (int r = x1; r < x2; r++) {
				for (int c = y1; c < y2; c++)
					map[r][c] = 1;
			}

		}

		// 채워진 행사장 카운팅
		int cnt = 0;
		for (int[] ma : map) {
			for (int m : ma) {
				if (m == 1)
					cnt++;
			}
		}
		System.out.println(cnt);

	}
}
