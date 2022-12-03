package baekjoon.그래프.아기_상어_2;

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

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 방향 배열
		int[] xArr = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] yArr = { -1, -1, 0, 1, 1, 1, 0, -1 };

		int[][] arr = new int[N][M];
		Queue<int[]> q = new LinkedList<int[]>();

		// 지도 입력
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				// 상어면 큐에 추가
				if (arr[i][j] == 1) {
					q.add(new int[] { i, j });
				}
			}
		}

		int max = 0;

		// bfs 시작
		while (!q.isEmpty()) {
			int[] now = q.poll();
			max = Math.max(max, arr[now[0]][now[1]]);

			for (int i = 0; i < 8; i++) {
				int nextX = now[0] + xArr[i];
				int nextY = now[1] + yArr[i];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
					continue;
				}

				if (arr[nextX][nextY] == 0) {
					q.add(new int[] { nextX, nextY });
					arr[nextX][nextY] = arr[now[0]][now[1]] + 1;
				}
			}
		}

		System.out.println(max - 1);

	}
}
