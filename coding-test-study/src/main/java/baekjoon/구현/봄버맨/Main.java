package baekjoon.±¸Çö.º½¹ö¸Ç;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static int N;

	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			char[] str = br.readLine().toCharArray();

			for (int j = 0; j < C; j++) {

				map[i][j] = str[j] == '.' ? 0 : 1;
			}
		}
		int cnt = 1;

		while (cnt < N) {

			if (cnt % 2 == 1) {
				// ÆøÅºÀ»±òÀ½
				makeBomb();
			} else {
				// ÅÍÁü
				bombExplode();
			}

//			for (int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}
//			System.out.println("--------------------" + cnt);
			cnt++;
		}

		for (int[] ma : map) {
			for (int m : ma) {
				System.out.print(m == 0 ? "." : "O");
			}
			System.out.println();
		}

	}

	public static void makeBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j]++;
			}
		}
	}

	public static void bombExplode() {
		// boolean[][] v = new boolean[R][C];
		int[] xArr = { 1, -1, 0, 0 };
		int[] yArr = { 0, 0, 1, -1 };
		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 2) {

					q.add(new int[] { i, j });

				}
			}
		}
		while (!q.isEmpty()) {
			int[] now = q.poll();
			map[now[0]][now[1]] = 0;

			for (int k = 0; k < 4; k++) {
				int nextX = now[0] + xArr[k];
				int nextY = now[1] + yArr[k];
				if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)
					continue;

				map[nextX][nextY] = 0;
			}
		}
	}

}
