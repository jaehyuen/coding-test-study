package baekjoon.DP.점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int      N;

	static int[][]  arr;
	static long[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N   = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		v   = new long[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				v[i][j]   = -1;
			}
		}

	

		System.out.println(dfs(0, 0));
		for (long[] ar : v) {
			System.out.println(Arrays.toString(ar));
		}

	}

	public static long dfs(int x, int y) {
		if (x == N - 1 && y == N - 1)
			return 1;

		if (v[x][y] == -1) {
			v[x][y] = 0;

			for (int i = 0; i < 2; i++) {
				int nextX = x;
				int nextY = y;

				if (i == 0) {
					nextX += arr[x][y];
				} else {
					nextY += arr[x][y];
				}

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
					continue;

				v[x][y] += dfs(nextX, nextY);
			}
		}

		return v[x][y];
	}

}
