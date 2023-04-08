package baekjoon.그래프.미로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] xArr = { 1, -1, 0, 0 };
		int[] yArr = { 0, 0, 1, -1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		char[][] map = new char[n][n];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 방문 체크 및 벽 변경 횟수 최소 저장 배열
		int[][] v = new int[n][n];

		Queue<int[]> q = new LinkedList<int[]>();
		v[0][0] = 1;
		q.add(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = now[0] + xArr[i];
				int y = now[1] + yArr[i];

				if (x < 0 || x >= n || y < 0 || y >= n) {
					continue;
				}

				int tmp = 0;
				if (map[x][y] == '0') {

					// 다음 경로가 벽이면 벽 변경값을 증가해준다
					tmp = 1;
				}

				// 방문한적이 없거나 기존 방문보다 벽을 변경을 최소화 하면 탐색
				if (v[x][y] == 0 || v[x][y] > v[now[0]][now[1]] + tmp) {
					v[x][y] = v[now[0]][now[1]] + tmp;
					q.add(new int[] { x, y });
				}
			}
		}

		System.out.println(v[n - 1][n - 1] - 1);
	}
}