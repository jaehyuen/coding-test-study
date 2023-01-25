package baekjoon.구현.점프왕_쩰리_Small;

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

		int[] xArr = { 0, 1 };
		int[] yArr = { 1, 0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		boolean[][] v = new boolean[N][N];

		for (int i = 0; i < N; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();

		// 큐에 추가
		q.add(new int[] { 0, 0 });

		// 방문 체크
		v[0][0] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			// 도착지에 도착했으면 종료
			if (v[N - 1][N - 1]) {
				break;
			}

			// 갈수있는 거리
			int tmp = map[now[0]][now[1]];
			for (int i = 0; i < 2; i++) {

				int x = now[0] + (xArr[i] * tmp);
				int y = now[1] + (yArr[i] * tmp);

				// 범위 체크
				if (x < 0 || x >= N || y < 0 || y >= N) {
					continue;
				}

				if (!v[x][y]) {
					q.add(new int[] { x, y });
					v[x][y] = true;
				}

			}

		}

		if (v[N - 1][N - 1]) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}
}
