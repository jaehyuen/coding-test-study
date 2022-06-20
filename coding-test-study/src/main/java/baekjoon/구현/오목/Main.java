package baekjoon.구현.오목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr = new int[19][19];
	static boolean[][][] v = new boolean[19][19][4];

	static int[] xArr = { 0, 1, 1, 1 };
	static int[] yArr = { 1, 1, 0, -1 };

	static int winnerX = 20;
	static int winnerY = 20;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		// 모든 위치 탐색
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {

				// 흑, 백돌이면 탐색을 시작한다
				if (arr[i][j] != 0) {

					// 바둑알 색을 저장
					int color = arr[i][j];
					for (int k = 0; k < 4; k++) {

						// 승리자 위치 초기화
						winnerX = i + 1;
						winnerY = j + 1;

						// 해당 위치에서 해당 방향으로 탐색을 했었는지 확인
						if (!v[i][j][k]) {

							// 5목이 완성됫는지 확인한다
							if (find(color, i, j, k) + 1 == 5) {

								System.out.println(color);
								System.out.println(winnerX + " " + winnerY);
								return;
							}
						}
					}

				}
			}
		}

		// 승리자가 없으면 출력
		System.out.println(0);
	}

	public static int find(int color, int x, int y, int dir) {
		int nextX = x + xArr[dir];
		int nextY = y + yArr[dir];

		// 시작 돌 위치 변경
		if (y + 1 < winnerY || (y + 1 == winnerY && x + 1 < winnerX)) {

			winnerX = x + 1;
			winnerY = y + 1;

		}

		// 방향에 대해서 방문 처리한다
		v[x][y][dir] = true;

		if (nextX < 0 || nextX >= 19 || nextY < 0 || nextY >= 19)
			return 0;

		if (arr[nextX][nextY] != color)
			return 0;

		return find(color, nextX, nextY, dir) + 1;
	}
}
