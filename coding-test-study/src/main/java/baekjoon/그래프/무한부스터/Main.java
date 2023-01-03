package baekjoon.그래프.무한부스터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		int[]           xArr = { 0, 1 };
		int[]           yArr = { 1, 0 };
		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st   = new StringTokenizer(br.readLine());

		int             N    = Integer.parseInt(st.nextToken());
		int             M    = Integer.parseInt(st.nextToken());

		int[][]         map  = new int[N][M];
		int[][]         v    = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 시작 지점 추가
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0 });

		// 도착 할때까지 돌린다
		while (v[N - 1][M - 1] == 0) {
			int[] now = q.poll();

			// 아래쪽, 오른족 순으로 반복
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= map[now[0]][now[1]]; j++) {
					int x = now[0] + (xArr[i] * j);
					int y = now[1] + (yArr[i] * j);

					// 범위 체크
					if (x < 0 || x >= N || y < 0 || y >= M) {
						continue;
					}

					// 방문 안했을떄
					if (v[x][y] == 0) {

						// 큐에 추가 및 방문 체크
						q.add(new int[] { x, y });
						v[x][y] = v[now[0]][now[1]] + 1;
					}
				}
			}
		}

		System.out.println(v[N - 1][M - 1]);

	}
}
