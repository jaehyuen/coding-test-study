package baekjoon.그래프.녹색_옷_입은_애가_젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] xArr = { 1, -1, 0, 0 };
		int[] yArr = { 0, 0, 1, -1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 출력 카운팅
		int cnt = 1;

		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			// 비용과 각 위치별 최소 비용 체크용 배열
			int[][] cave = new int[N][N];
			int[][] map = new int[N][N];

			for (int i = 0; i < cave.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					map[i][j] = Integer.MAX_VALUE;
				}
			}

			// 우선순위큐
			PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
				return cave[o1[0]][o1[1]] - cave[o2[0]][o2[1]];
			});

			// 다익스트라 시작
			q.add(new int[] { 0, 0 });
			map[0][0] = cave[0][0];

			while (!q.isEmpty()) {
				int[] now = q.poll();

				for (int i = 0; i < 4; i++) {
					int nextX = now[0] + xArr[i];
					int nextY = now[1] + yArr[i];

					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
						continue;

					if (map[nextX][nextY] > map[now[0]][now[1]] + cave[nextX][nextY]) {
						map[nextX][nextY] = map[now[0]][now[1]] + cave[nextX][nextY];
						q.add(new int[] { nextX, nextY });

					}
				}
			}
			System.out.println("Problem " + cnt + ": " + map[N - 1][N - 1]);
			cnt++;

		}

	}

}
