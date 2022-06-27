package baekjoon.구현.미세먼지_안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int R;
	static int C;

	static int[] xDir = { 1, -1, 0, 0 };
	static int[] yDir = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < T; i++) {
			createDust();
			System.out.println(i + "번째 확산");
			for (int[] ar : arr) {
				System.out.println(Arrays.toString(ar));
			}
			System.out.println("-----------------------");
			cleanDust();
			System.out.println("공기청정기 실행");
			for (int[] ar : arr) {
				System.out.println(Arrays.toString(ar));
			}
			System.out.println("=======================");
		}

		// 미세먼지 카운팅
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 0) {
					cnt += arr[i][j];
				}
			}
		}
//		for (int[] ar : arr) {
//			System.out.println(Arrays.toString(ar));
//		}
		System.out.println(cnt);

	}

	public static void createDust() {

		int[][] after = new int[R][C];

		// 미세먼지 확장을 위해 미세먼지 탐색
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				// 미세 먼지가 있으면 확장
				if (arr[i][j] > 0) {
					int tmp = arr[i][j] / 5;
					after[i][j] += arr[i][j];

					for (int k = 0; k < 4; k++) {
						int nextX = i + xDir[k];
						int nextY = j + yDir[k];

						// 칸을 벗어나면 스킵
						if (nextX < 0 || nextX >= R || nextY < 0 | nextY >= C)
							continue;

						// 공기청정기가 있으면 스킵
						if (arr[nextX][nextY] == -1)
							continue;

						after[nextX][nextY] += tmp;
						after[i][j] -= tmp;
					}

				}

				if (arr[i][j] == -1) {
					after[i][j] = arr[i][j];
				}

			}
		}

		arr = after;
	}

	public static void cleanDust() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				// 공기청정기 위치를 찾는다
				if (arr[i][j] == -1) {

					// 첫번째 공기청정기를 가동하여 바람을 순환 시킨다
					int prev = arr[i][j + 1];
					int next = -1;
					for (int k = 2; k < C; k++) {
						next = arr[i][k];
						arr[i][k] = prev;
						prev = next;

					}

					for (int k = i - 1; k >= 0; k--) {
						next = arr[k][C - 1];
						arr[k][C - 1] = prev;
						prev = next;
					}

					for (int k = C - 2; k >= 0; k--) {
						next = arr[0][k];
						arr[0][k] = prev;
						prev = next;
					}

					for (int k = 1; k < i ; k++) {
						next = arr[k][0];
						arr[k][0] = prev;
						prev = next;
					}
					arr[i][j + 1] = 0;

					// 두번째 공기청정기를 가동하여 바람을 순환 시킨다
					prev = arr[i + 1][j + 1];
					next = -1;
					for (int k = 2; k < C; k++) {
						next = arr[i + 1][k];
						arr[i + 1][k] = prev;
						prev = next;

					}

					for (int k = i + 2; k < R; k++) {
						next = arr[k][C - 1];
						arr[k][C - 1] = prev;
						prev = next;
					}

					for (int k = C - 2; k >= 0; k--) {
						next = arr[R - 1][k];
						arr[R - 1][k] = prev;
						prev = next;
					}

					for (int k = R - 2; k > i + 1; k--) {
						next = arr[k][0];
						arr[k][0] = prev;
						prev = next;
					}
					arr[i + 1][j + 1] = 0;

					return;
				}
			}
		}
	}

}
