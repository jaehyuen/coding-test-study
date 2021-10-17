package baekjoon.분할정복.쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[][] arr;
	public static int N;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = tmp.charAt(j) - 48;

			}
		}
		find(N, 0, 0);

		System.out.println(sb.toString());

	}

	public static void find(int size, int x, int y) {

		int color = arr[y][x];
		boolean flag = true;

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {

				if (arr[i][j] != color) {
					flag = false;
				}

			}
		}

		if (flag) {
			sb.append(color);
		} else {
			size /= 2;
			sb.append("(");
			find(size, x, y);
			find(size, x + size, y);
			find(size, x, y + size);
			find(size, x + size, y + size);
			sb.append(")");
		}
	}

}
