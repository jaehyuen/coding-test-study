package baekjoon.그래프.점프왕_쩰리_Large;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] xArr = { 0, 1 };
	public static int[] yArr = { 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		boolean[][] v = new boolean[N][N];

		// 맵 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 시작지점을 큐에 넣어줌
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		v[0][0] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int tmp = map[now[0]][now[1]];

			// 도착 가능하면 탐색 종료
			if (v[N - 1][N - 1]) {
				break;
			}

			for (int i = 0; i < 2; i++) {

				// 오른쪽, 왼쪽 좌표 계산
				int x = now[0] + (tmp * xArr[i]);
				int y = now[1] + (tmp * yArr[i]);

				// 범위 체크
				if (x < 0 || x >= N || y < 0 || y >= N) {
					continue;
				}

				// 방문 체크
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
