package baekjoon.그래프.아기_상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] xArr = { 1, -1, 0, 0 };
	static int[] yArr = { 0, 0, 1, -1 };

	static int[][] arr;

	static int sharkX;
	static int sharkY;

	static int N;

	static int minX = Integer.MAX_VALUE;
	static int minY = Integer.MAX_VALUE;
	static int moveCnt = Integer.MAX_VALUE;

	static int eatCnt = 0;

	static int sharkSize = 2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		Queue<Node> q = new LinkedList<Node>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					arr[i][j] = 0;
					sharkX = j;
					sharkY = i;

				}

			}
		}

		int result = 0;
		while (true) {
			bfs();
			if (minX == Integer.MAX_VALUE || moveCnt == Integer.MAX_VALUE || minY == Integer.MAX_VALUE) {
				break;
			}
			// arr[minY][minX] = 9;
			arr[sharkY][sharkX] = 0;
			eatCnt++;

			if (eatCnt == sharkSize) {
				eatCnt = 0;
				sharkSize++;
			}
			sharkX = minX;
			sharkY = minY;

			result += moveCnt - 1;

		}

		System.out.println(result);

	}

	public static void bfs() {
		int[][] arr2 = new int[N][N];

		moveCnt = Integer.MAX_VALUE;
		minX = Integer.MAX_VALUE;
		minY = Integer.MAX_VALUE;

		Queue<Node> q = new LinkedList<Node>();

		q.add(new Node(sharkX, sharkY));
		arr2[sharkY][sharkX] = 1;

		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = node.x + xArr[i];
				int nextY = node.y + yArr[i];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					if (arr2[nextY][nextX] == 0 && arr[nextY][nextX] <= sharkSize) {
						q.add(new Node(nextX, nextY));
						arr2[nextY][nextX] += arr2[node.y][node.x] + 1;

						if (arr[nextY][nextX] > 0 && arr[nextY][nextX] < sharkSize) {
							if (moveCnt >= arr2[nextY][nextX]) {
								if (nextY < minY) {
									moveCnt = arr2[nextY][nextX];
									minX = nextX;
									minY = nextY;

								} else if (nextY == minY && nextX < minX) {
									moveCnt = arr2[nextY][nextX];
									minX = nextX;
									minY = nextY;
								}

							}
						}
					}

				}
			}
		}

	}
}

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
