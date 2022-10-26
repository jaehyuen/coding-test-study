package baekjoon.그래프.음식물_피하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
		int K = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[N][M];
		boolean[][] v = new boolean[N][M];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			map[x][y] = true;

		}

		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				// 방문한적이 없으면 bfs
				if (!v[i][j] && map[i][j]) {

					v[i][j] = true;

					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[] { i, j });

					int cnt = 0;

					while (!q.isEmpty()) {
						int[] now = q.poll();

						// 음식물 크기 카운팅
						cnt++;

						for (int k = 0; k < 4; k++) {
							int nextX = now[0] + xArr[k];
							int nextY = now[1] + yArr[k];

							// 범위에서 벗어나면 무시
							if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
								continue;
							}

							// 방문을 안햇고 쓰레기면 큐에 추가
							if (!v[nextX][nextY] && map[nextX][nextY]) {
								q.add(new int[] { nextX, nextY });
								v[nextX][nextY] = true;

							}
						}
					}

					// 최대값 갱신
					max = Math.max(max, cnt);
				}
			}
		}

		System.out.println(max);
	}

}
