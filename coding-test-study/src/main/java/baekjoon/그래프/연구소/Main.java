package baekjoon.그래프.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] arr;

	static int max = 0;

	static Queue<Location> baseQ = new LinkedList<Location>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 2) {
					baseQ.add(new Location(i, j));
				}
			}
		}

		creatWall(0, 0);
		System.out.println(max);

	}

	public static void creatWall(int start, int cnt) {
		if (cnt == 3) {
			max = Math.max(max, countSaveLocation());
			return;
		}

		for (int i = start; i < N * M; i++) {
			int x = i / M;
			int y = i % M;

			if (arr[x][y] == 0) {
				arr[x][y] = 1;
				creatWall(i + 1, cnt + 1);
				arr[x][y] = 0;
			}
		}
	}

	public static int countSaveLocation() {

		int[] xArr = { 0, 0, 1, -1 };
		int[] yArr = { 1, -1, 0, 0 };
		int[][] arr2 = new int[N][M];

		for (int i = 0; i < N; i++) {
			System.arraycopy(arr[i], 0, arr2[i], 0, M);
		}

		int cnt = 0;
		Queue<Location> q = new LinkedList<Location>();
		q.addAll(baseQ);

		while (!q.isEmpty()) {
			Location loc = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = loc.x + xArr[i];
				int nextY = loc.y + yArr[i];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
					continue;

				if (arr2[nextX][nextY] == 0) {
					q.add(new Location(nextX, nextY));
					arr2[nextX][nextY] = 2;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (arr2[i][j] == 0) {
					cnt++;
				}
			}
		}

		return cnt;

	}
}

class Location {
	int x;
	int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
