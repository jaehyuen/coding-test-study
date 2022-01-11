package baekjoon.그래프.영역_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader     br     = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer    st     = new StringTokenizer(br.readLine());

		ArrayList<Integer> result = new ArrayList<>();

		int[]              xArr   = { 0, 0, 1, -1 };
		int[]              yArr   = { 1, -1, 0, 0 };

		int                M      = Integer.parseInt(st.nextToken());
		int                N      = Integer.parseInt(st.nextToken());
		int                K      = Integer.parseInt(st.nextToken());

		int[][]            paper  = new int[M][N];
		boolean[][]        v      = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;

			for (int j = x1; j <= x2; j++) {
				for (int k = y1; k <= y2; k++) {
					paper[k][j]++;
				}
			}

		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {

				if (paper[i][j] == 0 && !v[i][j]) {
					int cnt = 0;
					v[i][j] = true;
					Queue<Node> q = new LinkedList<>();
					q.add(new Node(i, j));

					while (!q.isEmpty()) {
						cnt++;
						Node now = q.poll();

						for (int l = 0; l < 4; l++) {
							int nextX = now.x + xArr[l];
							int nextY = now.y + yArr[l];

							if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
								continue;

							if (!v[nextX][nextY] && paper[nextX][nextY] == 0) {
								q.add(new Node(nextX, nextY));
								v[nextX][nextY] = true;
							}

						}
					}
					result.add(cnt);
				}

			}
		}

		System.out.println(result.size());

		Collections.sort(result);

		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}