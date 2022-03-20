package baekjoon.그래프.섬의_개수;

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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 상하좌우 및 대각선 방향용 배열
		int[] wArr = { 0, 0, 1, -1, -1, -1, 1, 1 };
		int[] hArr = { 1, -1, 0, 0, -1, 1, 1, -1 };

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			// 둘다 0이면 반복 종료
			if (w == 0 && h == 0) {
				break;
			}

			// 지도 및 방문 체크용 배열
			int[][] map = new int[h][w];
			boolean[][] v = new boolean[h][w];

			// 지도 입력
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;

			// 맵을 bfs로 순회하며 섬의 갯수를 카운팅
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !v[i][j]) {
						cnt++;
						Queue<int[]> q = new LinkedList<>();
						q.add(new int[] { i, j });
						v[i][j] = true;

						while (!q.isEmpty()) {
							int[] now = q.poll();

							for (int k = 0; k < 8; k++) {
								int nextW = now[1] + wArr[k];
								int nextH = now[0] + hArr[k];

								if (nextW < 0 || nextW >= w || nextH < 0 || nextH >= h)
									continue;

								if (map[nextH][nextW] == 1 && !v[nextH][nextW]) {
									q.add(new int[] { nextH, nextW });
									v[nextH][nextW] = true;
								}
							}

						}
					}

				}
			}
			System.out.println(cnt);
		}

	}
}
