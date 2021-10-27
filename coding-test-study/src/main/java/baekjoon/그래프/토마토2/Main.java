package baekjoon.그래프.토마토2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br    = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st    = new StringTokenizer(br.readLine());
		int             M     = Integer.parseInt(st.nextToken());
		int             N     = Integer.parseInt(st.nextToken());
		int             H     = Integer.parseInt(st.nextToken());

		int[]           xArr  = { 0, 0, 1, -1, 0, 0 };
		int[]           yArr  = { 1, -1, 0, 0, 0, 0 };
		int[]           hArr  = { 0, 0, 0, 0, 1, -1 };

		int[][][]       arr   = new int[H][N][M];
		int             total = 0;
		int             cnt   = 0;
		int             max   = 0;

		Queue<Tomato>   queue = new LinkedList<Tomato>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 0)
						total++;
					else if (arr[i][j][k] == 1)
						queue.add(new Tomato(k, j, i));

				}

			}
		}

		while (!queue.isEmpty()) {
			Tomato to = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nextX = to.x + xArr[i];
				int nextY = to.y + yArr[i];
				int nextH = to.h + hArr[i];

				if (nextX < 0 || nextX >= M)
					continue;
				if (nextY < 0 || nextY >= N)
					continue;
				if (nextH < 0 || nextH >= H)
					continue;
				if (arr[nextH][nextY][nextX] == 0) {
					queue.add(new Tomato(nextX, nextY, nextH));
					arr[nextH][nextY][nextX] = arr[to.h][to.y][to.x] + 1;
					max                      = Math.max(arr[nextH][nextY][nextX], max);
					cnt++;
				}
			}

		}
//		System.out.println("total : " + total);
//		System.out.println("cnt : " + cnt);
//
//		for (int[][] ar : arr) {
//			for (int[] a : ar) {
//				for (int i : a) {
//					System.out.print(i + ",");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}

		if (total == 0) {
			System.out.println(0);

		} else if (total == cnt) {
			System.out.println(max-1);

		} else {
			System.out.println(-1);
		}
	}
}

class Tomato {
	int x;
	int y;
	int h;

	public Tomato(int x, int y, int h) {
		this.x = x;
		this.y = y;
		this.h = h;
	}
}
