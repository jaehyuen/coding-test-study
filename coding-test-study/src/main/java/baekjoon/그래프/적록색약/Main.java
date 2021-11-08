package baekjoon.그래프.적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));

		int            N    = Integer.parseInt(br.readLine());
		char[][]       arr  = new char[N][N];
		boolean[][]    v    = new boolean[N][N];
		boolean[][]    v2   = new boolean[N][N];

		int[]          xArr = { 0, 0, 1, -1 };
		int[]          yArr = { 1, -1, 0, 0 };

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine()
				.toCharArray();
		}


		int result  = 0;
		int result2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					Queue<Node> q = new LinkedList<Node>();
					q.add(new Node(j, i));
					v[i][j] = true;
					result++;

					while (!q.isEmpty()) {
						Node node = q.poll();

						for (int k = 0; k < 4; k++) {
							int nextX = node.x + xArr[k];
							int nextY = node.y + yArr[k];

							if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
								if (!v[nextY][nextX] && arr[nextY][nextX] == arr[node.y][node.x]) {
									q.add(new Node(nextX, nextY));
									v[nextY][nextX] = true;
								}

							}
						}
					}
				}
				if (!v2[i][j]) {
					Queue<Node> q = new LinkedList<Node>();
					q.add(new Node(j, i));
					v2[i][j] = true;
					result2++;

					while (!q.isEmpty()) {
						Node node = q.poll();

						for (int k = 0; k < 4; k++) {
							int nextX = node.x + xArr[k];
							int nextY = node.y + yArr[k];

							if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
								if (!v2[nextY][nextX]) {
									if (arr[node.y][node.x] == 'B' && arr[nextY][nextX] != arr[node.y][node.x]) {
										continue;

									} else if (arr[node.y][node.x] == 'R' && arr[nextY][nextX] == 'B') {
										continue;
									} else if (arr[node.y][node.x] == 'G' && arr[nextY][nextX] == 'B') {
										continue;
									}

									q.add(new Node(nextX, nextY));
									v2[nextY][nextX] = true;

								}
							}
						}
					}

				}
			}

		}
		System.out.println(result + " " + result2);

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
