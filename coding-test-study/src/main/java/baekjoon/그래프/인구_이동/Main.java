package baekjoon.그래프.인구_이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int L;
	static int R;
	static int[][] country;

	static int[] xArr = { 1, -1, 0, 0 };
	static int[] yArr = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		country = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		while (true) {
			if (!move()) {
				break;
			}
			cnt++;
		}

		System.out.println(cnt);

	}

	public static boolean move() {
		int[][] tmp = new int[N][N];
		int[] people = new int[N * N];
		int idx = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int person = 0;
				int cnt = 0;
				if (tmp[i][j] == 0) {
					tmp[i][j] = idx + 1;
					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[] { i, j });
					person += country[i][j];

					while (!q.isEmpty()) {
						cnt++;
						int[] now = q.poll();

						for (int k = 0; k < 4; k++) {
							int nextX = now[0] + xArr[k];
							int nextY = now[1] + yArr[k];

							if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
								continue;

							int tmp2 = Math.abs(country[nextX][nextY] - country[now[0]][now[1]]);

							if (tmp[nextX][nextY] == 0 && tmp2 >= L && tmp2 <= R) {
								tmp[nextX][nextY] = idx + 1;
								q.add(new int[] { nextX, nextY });
								person += country[nextX][nextY];
							}
						}
					}
					people[idx] = person / cnt;
					idx++;
				}

			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				country[i][j] = people[tmp[i][j] - 1];
			}
		}

		if (idx == N * N) {
			return false;
		} else {
			return true;
		}

	}

}
