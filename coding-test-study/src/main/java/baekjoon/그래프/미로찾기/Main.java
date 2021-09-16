package baekjoon.그래프.미로찾기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner  s    = new Scanner(System.in);
		String[] scan = s.nextLine()
			.split(" ");

		int      N    = Integer.parseInt(scan[0]);
		int      M    = Integer.parseInt(scan[1]);

		int[][]  arr  = new int[N][M];
		int[][]  bfs  = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = s.nextLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
			}
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(0, 0));
		bfs[0][0] = 1;

		while (!queue.isEmpty()) {
			Node n = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = n.x;
				int nextY = n.y;

				if (i == 0) {
					nextY += 1;
				} else if (i == 1) {
					nextY -= 1;
				} else if (i == 2) {
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

		for (int[] ar : bfs) {
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
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