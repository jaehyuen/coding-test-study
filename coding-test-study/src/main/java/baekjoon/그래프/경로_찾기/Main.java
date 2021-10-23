package baekjoon.그래프.경로_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];

		int INF = 987654321;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = INF;
//				if (i == j)
//					arr[i][j] = 0;
			}
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1) {
					arr[i][j] = 1;
					// arr[j][i] = 1;
				}

			}

		}

//		for (int[] ar : arr) {
//			for (int a : ar) {
//				if (a == INF) {
//					System.out.print(0 + " ");
//				} else {
//					System.out.print(1 + " ");
//				}
//
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println();

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {

					arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
				}
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (arr[i][j] == INF) {
					System.out.print(0 + " ");
				} else {
					System.out.print(1 + " ");
				}

			}
			System.out.println();
		}

	}
}
