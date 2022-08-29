package baekjoon.그래프.알고스팟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		int[]           xArr = { 1, -1, 0, 0 };
		int[]           yArr = { 0, 0, 1, -1 };

		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st   = new StringTokenizer(br.readLine());

		int             N    = Integer.parseInt(st.nextToken());
		int             M    = Integer.parseInt(st.nextToken());

		// 지도 배열
		char[][]        map  = new char[M][N];

		// 벽부순 횟수 배열
		int[][]         cnt  = new int[M][N];

		// 지도를 입력받는다
		for (int i = 0; i < M; i++) {
			map[i] = br.readLine()
				.toCharArray();
		}

		// 벽을 조금 부순 순서로 우선순위 큐를 생성한다
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> {
			return cnt[o1[0]][o1[1]] - cnt[o2[0]][o2[1]];
		});

		// 시작점 추가
		q.add(new int[] { 0, 0 });
		cnt[0][0] = 1;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nextX = now[0] + xArr[i];
				int nextY = now[1] + yArr[i];

				// 범위를 벗어나면 무시
				if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
					continue;

				// 방문한적이 없거나 기존 루트보다 효율적이면 변경
				if (cnt[nextX][nextY] == 0 || cnt[nextX][nextY] > cnt[now[0]][now[1]] + (map[nextX][nextY] - '0')) {

					cnt[nextX][nextY] = cnt[now[0]][now[1]] + (map[nextX][nextY] - '0');
					q.add(new int[] { nextX, nextY });
				}

			}
		}
		System.out.println(cnt[M - 1][N - 1] - 1);

	}
}
