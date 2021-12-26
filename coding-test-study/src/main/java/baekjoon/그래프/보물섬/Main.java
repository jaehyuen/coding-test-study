package baekjoon.그래프.보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;

		int[] xArr = { 1, -1, 0, 0 };
		int[] yArr = { 0, 0, 1, -1 };

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			arr[i] = tmp;

		}
		int[][] mem = new int[2][2];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (arr[i][j] == 'L') {
					int[][] dp = new int[N][M];
					Queue<Island> q = new LinkedList<Island>();
					q.add(new Island(i, j));
					dp[i][j] = 1;

					while (!q.isEmpty()) {
						Island now = q.poll();

						for (int k = 0; k < 4; k++) {
							int nextX = now.x + xArr[k];
							int nextY = now.y + yArr[k];

							if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
								continue;

							if (arr[nextX][nextY] == 'L' && dp[nextX][nextY] == 0) {
								q.add(new Island(nextX, nextY));
								dp[nextX][nextY] = dp[now.x][now.y] + 1;

								if (max < dp[nextX][nextY]) {
									max = dp[nextX][nextY];
									mem[0][0] = i;
									mem[0][1] = j;

									mem[1][0] = nextX;
									mem[1][1] = nextY;
								}

							}
						}
					}
				}

			}
		}

		int[][] dp = new int[N][M];
		Queue<Island> q = new LinkedList<Island>();
		q.add(new Island(mem[0][0], mem[0][1]));
		dp[mem[0][0]][mem[0][1]] = 1;

		while (!q.isEmpty()) {
			Island now = q.poll();

			for (int k = 0; k < 4; k++) {
				int nextX = now.x + xArr[k];
				int nextY = now.y + yArr[k];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
					continue;

				if (arr[nextX][nextY] == 'L' && dp[nextX][nextY] == 0) {
					q.add(new Island(nextX, nextY));
					dp[nextX][nextY] = dp[now.x][now.y] + 1;

					max = Math.min(max, dp[nextX][nextY]);

				}
			}
		}

		System.out.println(dp[mem[1][0]][mem[1][1]] - 1);

	}
}

class Island {
	int x;
	int y;

	public Island(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
