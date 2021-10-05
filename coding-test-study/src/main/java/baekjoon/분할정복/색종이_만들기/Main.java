package baekjoon.분할정복.색종이_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int     white = 0;
	public static int     blue  = 0;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            N  = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		find(0, 0, N);
		System.out.println(white);
		System.out.println(blue);

	}

	public static void find(int y, int x, int size) {

		if (colorCheck(y, x, size)) {
			if (arr[y][x] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		size /= 2;
		find(y, x, size);
		find(y + size, x, size);
		find(y, x + size, size);
		find(y + size, x + size, size);
	}

	public static boolean colorCheck(int y, int x, int size) {

		int color = arr[y][x];

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {

				if (arr[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}

}
