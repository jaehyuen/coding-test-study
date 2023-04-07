package baekjoon.구현.스타트_택시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int     N;
	public static int     M;

	public static int[][] map;

	public static int[]   xArr = { 1, -1, 0, 0 };
	public static int[]   yArr = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());

		// 현재 택시 위치
		int              x        = Integer.parseInt(st.nextToken()) - 1;
		int              y        = Integer.parseInt(st.nextToken()) - 1;

		int[]            now      = { x, y };

		ArrayList<int[]> customer = new ArrayList<int[]>();
		boolean[]        finished = new boolean[M];

		// 손님별 이동거리 계산
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken()) - 1;
			int tmp2 = Integer.parseInt(st.nextToken()) - 1;
			int tmp3 = Integer.parseInt(st.nextToken()) - 1;
			int tmp4 = Integer.parseInt(st.nextToken()) - 1;
			customer.add(new int[] { tmp1, tmp2, tmp3, tmp4 });

		}

		// 손님 위치 미리 정렬
		Collections.sort(customer, (o1, o2) -> {
			if ((o1[0] == o2[0])) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		for (int i = 0; i < M; i++) {

			int idx = 0;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {

				// 안태운 손님이면 거리 측정
				if (!finished[j]) {

					int[] c   = customer.get(j);

					// 현재 택시 위치에서 출발지 까지 거리 계산
					int   tmp = bfs(now[0], now[1], c[0], c[1]);

					// 최소값 저장
					if (tmp < min) {
						min = tmp;
						idx = j;
					}
				}

			}

			int[] c = customer.get(idx);

			// 이동 가능 여부 체크
			if (min < 0) {
				System.out.println(-1);
				return;
			}

			// 택시 이동(연료 차감)
			fuel -= min;

			// 연료 체크
			if (fuel < 0) {
				System.out.println(-1);
				return;
			}

			// 도착지로 이동 연료 계산
			int tmp = bfs(c[0], c[1], c[2], c[3]);

			// 택시 이동(연료 차감)
			fuel -= tmp;

			// 연료 체크
			if (fuel < 0) {
				System.out.println(-1);
				return;
			}

			// 연료 충전
			fuel          += tmp * 2;

			// 택시 위치 갱신

			now[0]         = c[2];
			now[1]         = c[3];
			finished[idx]  = true;

		}

		System.out.println(fuel);

	}

	public static int bfs(int startX, int startY, int endX, int endY) {

		int[][]      v = new int[N][N];

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { startX, startY });
		v[startX][startY] = 1;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (v[endX][endY] != 0) {
				break;
			}

			for (int j = 0; j < 4; j++) {
				int x = now[0] + xArr[j];
				int y = now[1] + yArr[j];

				if (x < 0 || x >= N || y < 0 || y >= N) {
					continue;
				}

				// 방문 안했고 벽이 아니면 큐에 추가
				if (v[x][y] == 0 && map[x][y] == 0) {
					q.add(new int[] { x, y });
					v[x][y] = v[now[0]][now[1]] + 1;
				}
			}
		}

		return v[endX][endY] - 1;
	}
}
