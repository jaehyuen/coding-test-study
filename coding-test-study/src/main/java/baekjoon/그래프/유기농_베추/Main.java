package baekjoon.그래프.유기농_베추;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int     T = Integer.parseInt(s.nextLine());

		for (int i = 0; i < T; i++) {
			String[] caseArr = s.nextLine()
				.split(" ");

			int      M       = Integer.parseInt(caseArr[0]);
			int      N       = Integer.parseInt(caseArr[1]);
			int      K       = Integer.parseInt(caseArr[2]);
			int[][]  arr     = new int[N][M];
			int[][]  bfs     = new int[N][M];

			for (int j = 0; j < K; j++) {

				String[] str = s.nextLine()
					.split(" ");
				int      x   = Integer.parseInt(str[0]);
				int      y   = Integer.parseInt(str[1]);
				arr[y][x] = 1;
			}

			ArrayList<Integer> list = new ArrayList<Integer>();

			for (int k = 0; k < N; k++) {
//				int cnt = 0;
				for (int j = 0; j < M; j++) {
					if (arr[k][j] == 1 && bfs[k][j] == 0) {
						Queue<Node> queue = new LinkedList<Node>();
						queue.add(new Node(k, j));
						bfs[k][j] = 1;
						int cnt = 0;
						while (!queue.isEmpty()) {
							cnt++;
							Node n = queue.poll();
							for (int a = 0; a < 4; a++) {
								int nextX = n.x;
								int nextY = n.y;

								if (a == 0) {
									nextY += 1;
								} else if (a == 1) {
									nextY -= 1;
								} else if (a == 2) {
									nextX += 1;
								} else {
									nextX -= 1;
								}

								if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && bfs[nextX][nextY] == 0) {
									if (arr[nextX][nextY] != 1) {
										continue;
									}
									queue.add(new Node(nextX, nextY));
									bfs[nextX][nextY] = bfs[n.x][n.y] + 1;
								}
							}
						}

						list.add(cnt);
					}
				}
			}
			System.out.println(list.size());

		}

	}

	public static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
