package baekjoon.그래프.양;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int totalWolf = 0;
		int totalSheep = 0;

		int[] xArr = { 1, -1, 0, 0 };
		int[] yArr = { 0, 0, 1, -1 };

		char[][] arr = new char[n][m];
		boolean[][] v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			arr[i] = tmp.toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!v[i][j] && arr[i][j] != '#') {
					v[i][j] = true;
					Queue<Node> q = new LinkedList<>();

					int wolf = 0;
					int sheep = 0;

					q.add(new Node(i, j));

					while (!q.isEmpty()) {
						Node now = q.poll();

						if (arr[now.x][now.y] == 'o') {
							sheep++;
						} else if (arr[now.x][now.y] == 'v') {
							wolf++;
						}

						for (int k = 0; k < 4; k++) {
							int nextX = now.x + xArr[k];
							int nextY = now.y + yArr[k];

							if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
								continue;

							if (!v[nextX][nextY] && arr[nextX][nextY] != '#') {
								q.add(new Node(nextX, nextY));
								v[nextX][nextY] = true;
							}
						}
					}

					if (wolf >= sheep) {
						totalWolf += wolf;

					} else {
						totalSheep += sheep;
					}

				}
			}
		}

		System.out.println(totalSheep + " " + totalWolf);
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
