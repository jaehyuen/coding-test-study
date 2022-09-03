package baekjoon.그래프.탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		int[] xArr = { 1, -1, 0, 0 };
		int[] yArr = { 0, 0, 1, -1, };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[][] water = new int[R][C];
		int[][] map = new int[R][C];

		// 시작과 끝위치 저장
		int[] start = new int[2];
		int[] end = new int[2];

		// bfs용 큐
		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < R; i++) {
			char[] arr = br.readLine().toCharArray();

			for (int j = 0; j < C; j++) {

				// 물을 채워준다
				if (arr[j] == '*') {
					water[i][j] = 1;
					q.add(new int[] { i, j });
				} else if (arr[j] == 'X') {
					// 돌 채운다
					water[i][j] = -1;
					map[i][j] = -1;
				} else if (arr[j] == 'S') {
					// 시작점을 저장
					map[i][j] = 1;

					start[0] = i;
					start[1] = j;
				} else if (arr[j] == 'D') {
//					// 시작점을 저장
					end[0] = i;
					end[1] = j;
				}
			}
		}

		// 물에 대한 bfs시작
		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = now[0] + xArr[i];
				int nextY = now[1] + yArr[i];

				// 범위를 지나면 무시
				if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)
					continue;

				if (water[nextX][nextY] == 0 && !(nextX == end[0] && nextY == end[1])) {
					// if (water[nextX][nextY] == 0) {
					q.add(new int[] { nextX, nextY });
					water[nextX][nextY] = water[now[0]][now[1]] + 1;
				}
			}
		}

		// 탈출 경로 bfs
		q.clear();
		q.add(start);

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = now[0] + xArr[i];
				int nextY = now[1] + yArr[i];

				// 범위를 지나면 무시
				if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)
					continue;

				// 물이 없고 방문 안한곳으로 간다
				if (map[nextX][nextY] == 0
						&& ((map[now[0]][now[1]] + 1 < water[nextX][nextY] || water[nextX][nextY] == 0)
								|| (nextX == end[0] && nextY == end[1]))) {
					q.add(new int[] { nextX, nextY });
					map[nextX][nextY] = map[now[0]][now[1]] + 1;
				}
			}
		}

		System.out.println(map[end[0]][end[1]] == 0 ? "KAKTUS" : map[end[0]][end[1]] - 1);
	}
}
