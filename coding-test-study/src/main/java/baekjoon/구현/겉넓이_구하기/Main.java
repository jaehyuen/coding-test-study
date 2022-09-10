package baekjoon.구현.겉넓이_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		int[] xArr = { 0, 0, 1, -1 };
		int[] yArr = { 1, -1, 0, 0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 2][M + 2];

		for (int i = 1; i <= N; i++) {

			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {

				// 인접한 칸과 높이차이가 있으면 증가
				for (int k = 0; k < 4; k++) {
					int tmp = arr[i][j] - arr[i + xArr[k]][j + yArr[k]];
					if (tmp >= 0) {
						cnt += tmp;
					}
				}

			}

		}

		cnt += N * M * 2;

		System.out.println(cnt);
	}
}
