package baekjoon.그래프.현수막;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		int[]           xArr = { 0, -1, -1, -1, 0, 1, 1, 1 };
		int[]           yArr = { -1, -1, 0, 1, 1, 1, 0, -1 };

		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st   = new StringTokenizer(br.readLine());

		int             M    = Integer.parseInt(st.nextToken());
		int             N    = Integer.parseInt(st.nextToken());

		boolean[][]     arr  = new boolean[M][N];
		boolean[][]     v    = new boolean[M][N];

		// 현수막 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());

				if (tmp == 1) {
					arr[i][j] = true;
				}
			}

		}

		int cnt = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {

				// 방문 안한 글씨면 탐색
				if (arr[i][j]) {

					cnt++;
					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[] { i, j });
					v[i][j] = true;

					while (!q.isEmpty()) {
						int[] now = q.poll();

						for (int k = 0; k < 8; k++) {
							int x = now[0] + xArr[k];
							int y = now[1] + yArr[k];

							// 범위 체크
							if (x < 0 || x >= M || y < 0 || y >= N) {
								continue;
							}

							// 방문 안했고 글자면 큐에 추가
							if (arr[x][y]) {
								q.add(new int[] { x, y });
								arr[x][y] = false;
							}

						}
					}

				}

			}
		}
		System.out.println(cnt);

	}
}
