package baekjoon.그래프.쉬운_최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		int[] xArr = { 1, -1, 0, 0 };
		int[] yArr = { 0, 0, 1, -1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		int[][] cnt = new int[n][m];
		boolean[][] v = new boolean[n][m];

		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 출발지점 설정
				if (map[i][j] == 2) {
					q.add(new int[] { i, j });
					v[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = now[0] + xArr[i];
				int y = now[1] + yArr[i];

				// 범위체크
				if (x < 0 || x >= n || y < 0 | y >= m) {
					continue;
				}

				// 이동 가능하며 방문 안했으면 큐에 추가
				if (map[x][y] == 1 && !v[x][y]) {
					q.add(new int[] { x, y });
					cnt[x][y] = cnt[now[0]][now[1]] + 1;
					v[x][y] = true;
				}
			}

		}

		StringBuilder sb = new StringBuilder();

		// 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				// 방문가능하거나 원래 못가는 곳은 cnt 출력
				if (v[i][j] || (!v[i][j] && map[i][j] == 0)) {
					sb.append(cnt[i][j] + " ");
				} else {
					sb.append(-1 + " ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

}
