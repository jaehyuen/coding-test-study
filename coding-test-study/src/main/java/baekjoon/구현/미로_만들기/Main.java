package baekjoon.구현.미로_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
		int            N    = Integer.parseInt(br.readLine());
		char[]         arr  = br.readLine()
			.toCharArray();

		boolean[][]    map  = new boolean[110][110];

		int[]          xArr = { 1, 0, -1, 0 };
		int[]          yArr = { 0, -1, 0, 1 };

		int            dir  = 0;

		int            nowX = 50;
		int            nowY = 50;

		// 최소 좌표
		int            x1   = 50;
		int            y1   = 50;

		// 최대 좌표
		int            x2   = 50;
		int            y2   = 50;

		map[nowX][nowY] = true;

		for (char c : arr) {
			switch (c) {
			case 'L':
				dir = check(dir - 1);
				break;
			case 'R':
				dir = check(dir + 1);
				break;
			case 'F':
				// 방향으로 직진
				nowX += xArr[dir];
				nowY += yArr[dir];
				// 방문체크
				map[nowX][nowY] = true;

				break;

			}

			// 최대 최소 저장
			x1 = Math.min(x1, nowX);
			y1 = Math.min(y1, nowY);
			x2 = Math.max(x2, nowX);
			y2 = Math.max(y2, nowY);
		}

		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (map[i][j]) {
					System.out.print(".");
				} else {
					System.out.print("#");
				}

			}
			System.out.println();
		}
	}

	/**
	 * 방향 전환 체크함수
	 * 
	 * @param dir
	 * @return
	 */
	public static int check(int dir) {
		if (dir == -1) {
			return 3;
		} else if (dir == 4) {
			return 0;
		}
		return dir;
	}
}
