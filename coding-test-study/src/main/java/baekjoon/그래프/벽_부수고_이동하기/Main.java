package baekjoon.그래프.벽_부수고_이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br     = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st     = new StringTokenizer(br.readLine());

		int             N      = Integer.parseInt(st.nextToken());
		int             M      = Integer.parseInt(st.nextToken());

		int[][]         arr    = new int[N][M];
		int[][]         v      = new int[N][M];

		int             result = -1;

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine()
				.toCharArray();

			for (int j = 0; j < M; j++) {
				arr[i][j] = tmp[j] - 48;

				v[i][j]   = Integer.MAX_VALUE;
			}

		}

		int[] xArr = { 0, 0, 1, -1 };
		int[] yArr = { 1, -1, 0, 0 };

		for (int i = 0; i < N; i++) {
			System.arraycopy(arr[i], 0, arr[i], 0, M);
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0, 0, 1, 0));
		v[0][0] = 0;

		while (!q.isEmpty()) {
			Node now = q.poll();

			if (now.x == N - 1 && now.y == M - 1) {
				result = now.dis;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = now.x + xArr[i];
				int nextY = now.y + yArr[i];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
					continue;

				if (v[nextX][nextY] <= now.break1)
					continue;

				if (arr[nextX][nextY] == 0) {
					q.add(new Node(nextX, nextY, now.dis + 1, now.break1));
					v[nextX][nextY] = now.break1;

				} else {
					if (now.break1 == 0) {
						q.add(new Node(nextX, nextY, now.dis + 1, now.break1 + 1));

						v[nextX][nextY] = now.break1 + 1;
					}

				}

			}

		}

		for (int[] ar : v) {
			System.out.println(Arrays.toString(ar));
		}
		System.out.println(result);

	}

}

class Node {
	int x;
	int y;
	int dis;
	int break1;

	public Node(int x, int y, int dis, int break1) {
		this.x      = x;
		this.y      = y;
		this.dis    = dis;
		this.break1 = break1;

	}
}
