package baekjoon.구현.별찍기_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            N  = Integer.parseInt(br.readLine());

		arr = new int[4 * (N - 1) + 1][4 * (N - 1) + 1];
		draw(N, 0);

		StringBuilder sb = new StringBuilder();

		// 별 출력
		for (int[] ar : arr) {
			for (int a : ar) {
				if (a == 1) {
					sb.append("*");

				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void draw(int n, int tmp) {
		// 0이면 재귀 종료
		if (n == 0) {
			return;
		}

		// n의 크기에 맞게 태두리에 별을찍는다
		for (int i = 0 + tmp; i < arr.length - tmp; i++) {
			arr[0 + tmp][i]              = 1;
			arr[i][0 + tmp]              = 1;
			arr[arr.length - tmp - 1][i] = 1;
			arr[i][arr.length - tmp - 1] = 1;
		}

		draw(n - 1, tmp + 2);

	}
}
