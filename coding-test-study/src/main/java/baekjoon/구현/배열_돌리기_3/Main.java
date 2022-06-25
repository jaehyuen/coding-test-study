package baekjoon.구현.배열_돌리기_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < R; i++) {
			int cal = Integer.parseInt(st.nextToken());

			switch (cal) {
			case 1:
				calculation1();
				break;
			case 2:
				calculation2();
				break;
			case 3:
				calculation3();
				break;
			case 4:
				calculation4();
				break;
			case 5:
				calculation5();
				break;
			case 6:
				calculation6();
				break;

			}
		}

		for (int[] ar : arr) {
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

	}

	public static void calculation1() {
		int[][] result = new int[N][M];

		int idx = N - 1;

		// 상하 반전
		for (int i = 0; i < N / 2; i++) {
			result[i] = arr[idx];
			result[idx] = arr[i];

			idx--;

		}

		arr = result;
	}

	public static void calculation2() {
		int[][] result = new int[N][M];
		int idx = M - 1;

		// 좌우 반전
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i][j] = arr[i][idx];
				result[i][idx] = arr[i][j];
				idx--;
			}

			// 인덱스 초기화
			idx = M - 1;

		}
		arr = result;
	}

	public static void calculation3() {
		int[][] result = new int[M][N];
		int idx = N - 1;

		// 오른쪽으로 회전
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[j][idx] = arr[i][j];

			}
			idx--;

		}
		arr = result;

		// N M 변경
		int tmp = N;
		N = M;
		M = tmp;
	}

	public static void calculation4() {
		int[][] result = new int[M][N];
		int idx = M - 1;

		// 왼쪽으로 회전
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[idx][i] = arr[i][j];
				idx--;
			}
			idx = M - 1;

		}
		arr = result;

		// N M 변경
		int tmp = N;
		N = M;
		M = tmp;
	}

	public static void calculation5() {

		int[][] result = new int[N][M];

		// 자리이동1
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i][j] = arr[i + (N / 2)][j];
			}

		}

		// 자리이동2
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i][j + (M / 2)] = arr[i][j];
			}

		}

		// 자리이동3
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i + (N / 2)][j + (M / 2)] = arr[i][j + (M / 2)];
			}

		}

		// 자리이동4
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i + (N / 2)][j] = arr[i + (N / 2)][j + (M / 2)];
			}

		}

		arr = result;
	}

	public static void calculation6() {

		int[][] result = new int[N][M];

		// 자리이동1
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i][j] = arr[i][j + (M / 2)];
			}

		}

		// 자리이동2
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i][j + (M / 2)] = arr[i + (N / 2)][j + (M / 2)];
			}

		}

		// 자리이동3
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i + (N / 2)][j + (M / 2)] = arr[i + (N / 2)][j];
			}

		}

		// 자리이동4
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				result[i + (N / 2)][j] = arr[i][j];
			}

		}

		arr = result;
	}

}
