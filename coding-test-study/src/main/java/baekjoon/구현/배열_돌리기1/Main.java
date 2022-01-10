package baekjoon.구현.배열_돌리기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int     N;
	static int     M;
	static int     R;
	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N   = Integer.parseInt(st.nextToken());
		M   = Integer.parseInt(st.nextToken());

		R   = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// print();

		for (int i = 0; i < R; i++) {
			spin(0, N - 1, 0, M - 1);
			// print();
		}

		for (int[] ar : arr) {
			for (int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
		}

	}

	public static void print() {

		System.out.println();
		for (int[] ar : arr) {
			System.out.println(Arrays.toString(ar));
		}
		System.out.println();
	}

	public static void spin(int x1, int x2, int y1, int y2) {
		int tmp1 = -1;
		int tmp2 = -1;

		for (int i = y2; i >= y1; i--) {
			tmp2       = arr[x1][i];
			arr[x1][i] = tmp1;
			tmp1       = tmp2;

		}
		for (int i = x1 + 1; i <= x2; i++) {
			tmp2       = arr[i][y1];
			arr[i][y1] = tmp1;
			tmp1       = tmp2;

		}
		for (int i = y1 + 1; i <= y2; i++) {
			tmp2       = arr[x2][i];
			arr[x2][i] = tmp1;
			tmp1       = tmp2;

		}
		for (int i = x2 - 1; i >= x1; i--) {
			tmp2       = arr[i][y2];
			arr[i][y2] = tmp1;
			tmp1       = tmp2;

		}

		x1++;
		x2--;
		y1++;
		y2--;

		// System.out.println("x1 : " + x1 + ", x2 : " + x2 + ", y1 : " + y1 + ", y2 : "
		// + y2);

		if (x1 >= x2) {
			return;
		}
		if (y1 >= y2) {
			return;
		}
		spin(x1, x2, y1, y2);

	}

}
