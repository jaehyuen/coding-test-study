package baekjoon.그래프.빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N;
	static int M;

	static int[] xDir = { 1, -1, 0, 0 };
	static int[] yDir = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;

		while (true) {

			// 빙산 체크
			int cnt = check();

			if (cnt == 0) {
				System.out.println(0);
				return;
			} else if (cnt > 1) {
				System.out.println(year);
				return;
			}

			// 빙산 지우기
			plusYear();
			year++;
		}
	}

	public static void plusYear() {
		int[][] after = new int[N][M];

		// 빙산을 녹인다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] != 0) {
					int cnt = 0;

					for (int k = 0; k < 4; k++) {
						int nextX = i + xDir[k];
						int nextY = j + yDir[k];

						// 지도를 벗어나면 바다로 취급
						if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
							cnt++;
							continue;
						}

						// 바다면 카운트 증가
						if (map[nextX][nextY] == 0) {
							cnt++;
						}

					}

					// 빙산을 녹이고 0이하이면 0이로 변경
					after[i][j] = map[i][j] - cnt < 0 ? 0 : map[i][j] - cnt;
				}

			}
		}

		map = after;

	}

	public static int check() {

		boolean[][] v = new boolean[N][M];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				// 빙산을 bfs로 조회
				if (!v[i][j] && map[i][j] != 0) {
					cnt++;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] { i, j });

					// 방문체크
					v[i][j] = true;

					while (!q.isEmpty()) {
						int[] now = q.poll();

						for (int k = 0; k < 4; k++) {
							int nextX = now[0] + xDir[k];
							int nextY = now[1] + yDir[k];

							// 범위 체크
							if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
								continue;
							}

							if (!v[nextX][nextY] && map[nextX][nextY] != 0) {
								q.add(new int[] { nextX, nextY });
								v[nextX][nextY] = true;
							}
						}
					}
				}

			}
		}
		return cnt;

	}
}
