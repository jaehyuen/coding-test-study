package baekjoon.구현.치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		int[] xArr = { 1, -1, 0, 0 };
		int[] yArr = { 0, 0, 1, -1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int totalCnt = 0;

		// 모눈종이에 치즈상태 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 치즈 총 갯수 카운팅
				if (map[i][j] == 1) {
					totalCnt++;
				}

			}
		}

		int days = 0;

		// 치즈가 다 녹을때까지 돌림
		while (totalCnt > 0) {
			days++;

			// 빈공간 체크
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[] { 0, 0 });
			map[0][0] -= 1;

			while (!q.isEmpty()) {
				int[] now = q.poll();

				for (int k = 0; k < 4; k++) {
					int x = now[0] + xArr[k];
					int y = now[1] + yArr[k];

					if (x < 0 || x >= N || y < 0 || y >= M) {
						continue;
					}

					// 기존이 빈칸이거나(0보다 작을떄) 방금 지워진(2)곳이면 값 초기화
					if ((map[x][y] > map[0][0] && map[x][y] <= 0) || map[x][y] == 2) {
						q.add(new int[] { x, y });
						map[x][y] = map[0][0];

					}
				}
			}

			boolean[][] v = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					// 치즈를 찾는다
					if (map[i][j] == 1 && !v[i][j]) {

						q = new LinkedList<int[]>();
						q.add(new int[] { i, j });
						v[i][j] = true;

						while (!q.isEmpty()) {
							int[] now = q.poll();

							int tmp = 0;

							for (int k = 0; k < 4; k++) {
								int x = now[0] + xArr[k];
								int y = now[1] + yArr[k];

								if (x < 0 || x >= N || y < 0 || y >= M) {
									continue;
								}

								if (map[x][y] == 1 && !v[x][y]) {
									q.add(new int[] { x, y });
									v[x][y] = true;

								}

								// 공기와 접촉면 체크
								if (map[x][y] == map[0][0]) {
									tmp++;
								}
							}

							// 2개 이상이면 다음날 녹음
							if (tmp >= 2) {
								map[now[0]][now[1]] = 2;
								totalCnt--;
							}
						}

					}

				}
			}

		}
		System.out.println(days);

	}
}
