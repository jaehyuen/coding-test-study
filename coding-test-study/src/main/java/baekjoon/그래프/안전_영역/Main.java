package baekjoon.그래프.안전_영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());

		int[][]         arr = new int[N][N];
		int             max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {

				arr[i][j] = Integer.parseInt(st.nextToken());
				max       = Math.max(arr[i][j], max);

			}
		}

		int[] xArr   = { 0, 0, 1, -1 };
		int[] yArr   = { 1, -1, 0, 0 };

		int   result = 0;

		for (int i = 0; i < max; i++) {
			boolean[][] v   = new boolean[N][N];
			int         cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if (!v[j][j2] && arr[j][j2] > i) {
						Queue<Node> q = new LinkedList<Node>();
						cnt++;
						v[j][j2] = true;
						q.add(new Node(j, j2));

						while (!q.isEmpty()) {

							Node now = q.poll();

							for (int k = 0; k < 4; k++) {
								int nextX = now.x + xArr[k];
								int nextY = now.y + yArr[k];

								if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
									continue;
								}

								if (!v[nextX][nextY] && arr[nextX][nextY] > i) {
									q.add(new Node(nextX, nextY));
									v[nextX][nextY] = true;
								}
							}
						}
					}

				}
			}

			result = Math.max(result, cnt);

		}

		System.out.println(result);

	}
}

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
};