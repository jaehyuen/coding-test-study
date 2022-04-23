package baekjoon.브루트포스.사탕_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int[] xArr = { 1, -1, 0, 0 };
	static int[] yArr = { 0, 0, 1, -1 };

	static char[][] candy;
	static int N;
	static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		candy = new char[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			candy[i] = ("." + br.readLine()).toCharArray();
		}
		Arrays.fill(candy[0], '.');

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				// 색 변경전 체크
				checkCandy(i, j, candy[i][j]);
				for (int k = 0; k < 4; k++) {

					// 범위에 벗어나면 무시
					if (i + yArr[k] < 1 || i + yArr[k] > N || j + xArr[k] < 1 || j + xArr[k] > N)
						continue;

					// 두칸의 색이 다르면 변경
					if (candy[i][j] != candy[i + yArr[k]][j + xArr[k]]) {

						// 색 교환
						char tmp = candy[i][j];
						candy[i][j] = candy[i + yArr[k]][j + xArr[k]];
						candy[i + yArr[k]][j + xArr[k]] = tmp;

						checkCandy(i, j, candy[i][j]);
						// 색 원상 복구
						candy[i + yArr[k]][j + xArr[k]] = candy[i][j];
						candy[i][j] = tmp;

					}

				}

			}

		}

		System.out.println(max);
	}

	public static void checkCandy(int y, int x, char color) {

		// 열, 행을 확인한다
		for (int i = 0; i < 2; i++) {
			int cnt = 0;

			for (int j = 1; j <= N; j++) {

				if (i == 0) {

					// 연속되지 않으면 카운트 초기화
					if (candy[y][j] != candy[y][j - 1]) {
						cnt = 1;
					} else {
						cnt++;

					}

				} else {

					// 연속되지 않으면 카운트 초기화
					if (candy[j][x] != candy[j - 1][x]) {
						cnt = 1;
					} else {
						cnt++;

					}
				}
				max = Math.max(cnt, max);
			}

		}

	}
}
