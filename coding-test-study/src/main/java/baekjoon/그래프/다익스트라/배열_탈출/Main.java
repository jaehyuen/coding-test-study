package baekjoon.그래프.다익스트라.배열_탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 이차원 배열, 디피 배열 선언
		int[][] tmp = new int[n][n];
		int[][] dp = new int[n][n];

		// 이차원 배열 초기화
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				tmp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 양 뱡향의 비용 변수
				int cost1 = 0;
				int cost2 = 0;

				// 양 뱡향의 총 비용 변수
				int tmp1 = 0;
				int tmp2 = 0;

				// i>0 일떄 비용 계산 로직
				if (i > 0) {
					cost1 = tmp[i][j] - tmp[i - 1][j] + 1 < 1 ? 0 : tmp[i][j] - tmp[i - 1][j] + 1;
					tmp1 = dp[i - 1][j] + cost1;
					if (j == 0) {
						tmp2 = Integer.MAX_VALUE;
					}

				}

				// j>0 일떄 비용 계산 로직
				if (j > 0) {
					cost2 = tmp[i][j] - tmp[i][j - 1] + 1 < 1 ? 0 : tmp[i][j] - tmp[i][j - 1] + 1;
					tmp2 = dp[i][j - 1] + cost2;
					if (i == 0) {
						tmp1 = Integer.MAX_VALUE;
					}

				}

				if (i == 0 && j == 0) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Math.min(tmp1, tmp2);
				}

			}
		}

		System.out.println(dp[n - 1][n - 1]);
//		boolean[][] v = new boolean[n][n];
//
//		int[] xArr = { 0, 1 };
//		int[] yArr = { 1, 0 };
//
//		for (int i = 0; i < n; i++) {
//			Arrays.fill(dp[i], 987654321);
//		}
//
//		for (int i = 0; i < n; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < n; j++) {
//				tmp[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
//			return (tmp[o1[0]][o1[1]] - tmp[o1[2]][o1[3]]) - (tmp[o2[0]][o2[1]] - tmp[o2[2]][o2[3]]);
//		});
//
//		q.add(new int[] { 0, 0, 0, 0 });
//		dp[0][0] = 0;
//
//		while (!q.isEmpty()) {
//			int[] now = q.poll();
//
//			// �湮�߾����� ��Ƽ��
//			if (v[now[2]][now[3]])
//				continue;
//			v[now[2]][now[3]] = true;
//
//			for (int i = 0; i < 2; i++) {
//				int nextX = now[2] + xArr[i];
//				int nextY = now[3] + yArr[i];
//
//				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
//					continue;
//
//				int dis = tmp[nextX][nextY] - tmp[now[0]][now[1]] + 1;
//				dis = dis < 0 ? 0 : dis;
//
//				if (dp[nextX][nextY] > dp[now[2]][now[3]] + dis) {
//					dp[nextX][nextY] = dp[now[2]][now[3]] + dis;
//					q.add(new int[] { now[2], now[3], nextX, nextY });
//				}
//
//			}
//		}
//
//		for (int[] d : dp) {
//			System.out.println(Arrays.toString(d));
//		}
//		System.out.println(dp[n - 1][n - 1]);

	}
}
