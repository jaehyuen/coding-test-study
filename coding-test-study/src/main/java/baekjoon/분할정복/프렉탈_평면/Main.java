package baekjoon.분할정복.프렉탈_평면;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map;
	static int N;
	static int K;

	static int R1;
	static int R2;
	static int C1;
	static int C2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(st.nextToken());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		R1 = Integer.parseInt(st.nextToken());
		R2 = Integer.parseInt(st.nextToken());
		C1 = Integer.parseInt(st.nextToken());
		C2 = Integer.parseInt(st.nextToken());

		// 한변의 길이
		int tmp = (int) Math.pow(N, s);

		// 프렉탈 평면 그리기
		map = new boolean[R2 - R1 + 1][C2 - C1 + 1];

		draw(tmp, 0, 0, false);

		StringBuilder sb = new StringBuilder();

		for (boolean[] ma : map) {
			for (boolean m : ma) {
				if (m) {
					sb.append(1);

				} else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

	public static void draw(int length, int x, int y, boolean isBlack) {

		// 범위에 벗어난다면 안함
		if (length + x <= R1 || x > R2 || length + y <= C1 || y > C2) {
			return;
		}

		System.out.println(x +", "+y);
		// 1칸짜리면 색칠
		if (length == 1) {
			map[x - R1][y - C1] = isBlack;
			return;
		}

		// 다음 길이
		int nextLength = length / N;

		// 검정 시작위치
		int blackStart = (N - K) / 2;

		// 검정 종료위치
		int blackEnd = N - blackStart;

		for (int i = 0; i < N; i++) {
			int nX = x + nextLength * i;

			for (int j = 0; j < N; j++) {
				int nY = y + nextLength * j;
				draw(nextLength, nX, nY,
						isBlack || (i >= blackStart && i < blackEnd) && (j >= blackStart && j < blackEnd));
			}
		}

	}
}
