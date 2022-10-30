package baekjoon.그래프.전쟁_전투;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

		char[][] arr = new char[M][N];
		boolean[][] v = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			arr[i] = br.readLine().toCharArray();

		}

		// 아군 적군 카운팅
		int bCnt = 0;
		int wCnt = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {

					// 현재 병사의 색갈
					char color = arr[i][j];
					int cnt = 0;

					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[] { i, j });
					v[i][j] = true;

					while (!q.isEmpty()) {
						int[] now = q.poll();

						cnt++;

						for (int k = 0; k < 4; k++) {
							int nextX = now[0] + xArr[k];
							int nextY = now[1] + yArr[k];

							// 범위를 벗어나면 그만
							if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
								continue;

							// 방문 안하고 같은색이면 큐에 추가
							if (!v[nextX][nextY] && arr[nextX][nextY] == color) {
								v[nextX][nextY] = true;
								q.add(new int[] { nextX, nextY });
							}

						}

					}

					if (color == 'B') {
						bCnt += cnt * cnt;
					} else {
						wCnt += cnt * cnt;
					}
				}
			}
		}
		System.out.println(wCnt + " " + bCnt);

	}
}
