package baekjoon.그래프.바닥_장식;

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
	public static void main(String[] args) throws IOException {

		int[] xArr = { 0, 1 };
		int[] yArr = { 1, 0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		boolean[][] v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				// 방문을 안했을때만 체크
				if (!v[i][j]) {

					cnt++;
					v[i][j] = true;
					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] now = q.poll();

						if (map[now[0]][now[1]] == '-') {
							int nextX = now[0] + xArr[0];
							int nextY = now[1] + yArr[0];

							if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
								continue;

							// 방문한적 없고 같은모양이면
							if (!v[nextX][nextY] && map[nextX][nextY] == '-') {
								v[nextX][nextY] = true;
								q.add(new int[] { nextX, nextY });
							}

						} else {
							int nextX = now[0] + xArr[1];
							int nextY = now[1] + yArr[1];

							if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
								continue;

							// 방문한적 없고 같은모양이면
							if (!v[nextX][nextY] && map[nextX][nextY] == '|') {
								v[nextX][nextY] = true;
								q.add(new int[] { nextX, nextY });
							}
						}

					}
				}
			}
		}

		System.out.println(cnt);

	}

}
