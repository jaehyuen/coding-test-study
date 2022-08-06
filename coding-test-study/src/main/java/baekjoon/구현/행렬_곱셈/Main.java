package baekjoon.구현.행렬_곱셈;

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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 행렬 1 입력
		int[][] arr1 = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 행렬 2 입력
		int[][] arr2 = new int[M][K];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < K; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 행렬곱셈 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				int tmp = 0;

				for (int a = 0; a < M; a++) {
					tmp += arr1[i][a] * arr2[a][j];
				}

				System.out.print(tmp + " ");

			}
			System.out.println();

		}

	}
}
