package baekjoon.구현.마라톤_1;

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

	static int N;
	static int[][] arr1;
	static int[][] arr2;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr1 = new int[N][2];
		arr2 = new int[N - 3][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr1[i][0] = x;
			arr1[i][1] = y;
		}

		int dis[] = new int[N - 1];
		int sum = 0;

		// 거리 저장
		for (int i = 0; i < N - 1; i++) {
			dis[i] = Math.abs(arr1[i][0] - arr1[i + 1][0]) + Math.abs(arr1[i][1] - arr1[i + 1][1]);
			sum += dis[i];
		}

		int max = 0;

		// 스킵값 파악
		for (int i = 0; i < N - 2; i++) {
			int skip = Math.abs(arr1[i][0] - arr1[i + 2][0]) + Math.abs(arr1[i][1] - arr1[i + 2][1]);
			max = Math.max(max, dis[i] + dis[i + 1] - skip);
		}
		System.out.println(sum - max);

	}

}
