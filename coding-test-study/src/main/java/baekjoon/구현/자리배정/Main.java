package baekjoon.구현.자리배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             C  = Integer.parseInt(st.nextToken());
		int             R  = Integer.parseInt(st.nextToken());

		int             K  = Integer.parseInt(br.readLine());

		if (R * C < K) {
			// 대기가 불가능 하면 0
			System.out.println(0);
		} else if (K == 1) {
			System.out.println("1 1");
		} else {
			int[][] arr = new int[R][C];

			// 방향 배열
			int[]   dx  = { 1, 0, -1, 0 };
			int[]   dy  = { 0, 1, 0, -1 };

			int     x   = 0;
			int     y   = 0;
			int     cnt = 1;

			// 초기값 세팅
			arr[x][y] = 1;

			while (true) {

				// 방향 전환
				for (int i = 0; i < 4; i++) {
					while (true) {

						x = x + dx[i];
						y = y + dy[i];

						// 범위를 벗어나면 그만
						if (0 > x || R <= x || 0 > y || C <= y) {
							x = x - dx[i];
							y = y - dy[i];
							break;
						}

						// 방문하면 그만
						if (arr[x][y] != 0) {
							x = x - dx[i];
							y = y - dy[i];
							break;
						}

						arr[x][y] = ++cnt;

						if (cnt == K) {
							System.out.println((y + 1) + " " + (x + 1));
							return;
						}
					}

				}
			}
		}
	}
}
