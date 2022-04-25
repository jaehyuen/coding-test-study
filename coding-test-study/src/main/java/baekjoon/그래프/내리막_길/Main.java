package baekjoon.그래프.내리막_길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int[] xArr = { 0, 0, 1, -1 };
	static int[] yArr = { 1, -1, 0, 0 };

	static int M;
	static int N;

	static int[][] arr;
	static int[][] dp;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[M][N];
		dp = new int[M][N];
		v = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		System.out.println(find(0, 0));

	}

	public static int find(int y, int x) {

		// 끝에 도착하면 1을 리턴
		if (y == M - 1 && x == N - 1)
			return 1;

		// 방문 햇으면 디피 리턴
		if (dp[y][x] != -1)
			return dp[y][x];

		dp[y][x] = 0;

		for (int i = 0; i < 4; i++) {

			int nextY = y + yArr[i];
			int nextX = x + xArr[i];

			if (nextY < 0 || nextY >= M || nextX < 0 || nextX >= N)
				continue;

			if (arr[y][x] > arr[nextY][nextX]) {

				dp[y][x] += find(nextY, nextX);

			}

		}
		return dp[y][x];

	}

}
