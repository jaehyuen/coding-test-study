package baekjoon.구현.거북이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		int[]          xArr = { -1, 0, 1, 0 };
		int[]          yArr = { 0, 1, 0, -1 };

		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
		int            T    = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			char[] func = br.readLine()
				.toCharArray();

			int[]  now  = { 0, 0 };
			int[]  max  = { 0, 0 };
			int[]  min  = { 0, 0 };
			int    dir  = 0;

			// 커멘드 실행
			for (char f : func) {

				switch (f) {
				case 'F':
					now[0] += xArr[dir];
					now[1] += yArr[dir];
					break;
				case 'B':
					now[0] -= xArr[dir];
					now[1] -= yArr[dir];
					break;
				case 'L':
					dir--;
					break;
				case 'R':
					dir++;
					break;

				}

				// 최대 최소값 구하기
				max[0] = Math.max(max[0], now[0]);
				max[1] = Math.max(max[1], now[1]);

				min[0] = Math.min(min[0], now[0]);
				min[1] = Math.min(min[1], now[1]);

				// 방향 범위 체크
				if (dir == 4) {
					dir = 0;
				} else if (dir == -1) {
					dir = 3;
				}

			}

			// 최대 최소에 포함되는 간을 구한다
			System.out.println((max[0] - min[0]) * (max[1] - min[1]));

		}
	}
}
