package baekjoon.브루트포스.테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int max = 0;

		int[][] yArr = { { 0, 0, 0, 0 }, { 0, 1, 2, 3 }, { 0, 0, 1, 1 }, { 0, 1, 2, 2 }, { 0, 0, -1, -2 },
				{ 0, 0, 1, 2 }, { 0, 0, 1, 2 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 1, 1, 2 }, { 0, -1, -1, -2 },
				{ 0, 0, -1, -1 }, { 0, 0, 1, 1 }, { 0, 0, 0, -1 }, { 0, 0, 0, 1 }, { 0, 0, -1, 1 }, { 0, 1, 2, 1 },
				{ 0, 1, 1, 1 }, { 0, 0, 0, -1 } };
		int[][] xArr = { { 0, 1, 2, 3 }, { 0, 0, 0, 0 }, { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 0, 1, 0, 0 },
				{ 0, 1, 1, 1 }, { 0, 1, 2, 0 }, { 0, 1, 2, 2 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 2 },
				{ 0, 1, 1, 2 }, { 0, 1, 2, 1 }, { 0, 1, 2, 1 }, { 0, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 1, 2 },
				{ 0, 1, 2, 2 } };

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 19; k++) {
					int sum = 0;
					for (int k2 = 0; k2 < 4; k2++) {
						int nextY = i + yArr[k][k2];
						int nextX = j + xArr[k][k2];
						if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
							sum += arr[nextY][nextX];
						} else {
							break;
						}
					}

					if (max < sum) {
						max = sum;
					}
				}

			}
		}

		System.out.println(max);

	}

}
