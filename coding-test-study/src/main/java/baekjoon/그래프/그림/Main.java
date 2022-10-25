package baekjoon.그래프.그림;

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

		int[]           xArr = { 1, -1, 0, 0 };
		int[]           yArr = { 0, 0, 1, -1 };

		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st   = new StringTokenizer(br.readLine());

		int             n    = Integer.parseInt(st.nextToken());
		int             m    = Integer.parseInt(st.nextToken());

		int[][]         map  = new int[n][m];
		boolean[][]     v    = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int totalCnt = 0;
		int max      = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				// 방문한적이 없으면 bfs
				if (!v[i][j] && map[i][j] == 1) {

					v[i][j] = true;

					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[] { i, j });

					// 그림 카운팅
					totalCnt++;
					int cnt = 0;

					while (!q.isEmpty()) {
						int[] now = q.poll();

						// 그림 넓이 카운팅
						cnt++;

						for (int k = 0; k < 4; k++) {
							int nextX = now[0] + xArr[k];
							int nextY = now[1] + yArr[k];

							// 범위에서 벗어나면 무시
							if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
								continue;
							}

							// 방문을 안햇고 그림이면 큐에 추가
							if (!v[nextX][nextY] && map[nextX][nextY] == 1) {
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
		System.out.println(totalCnt);
		System.out.println(max);
	}

}
