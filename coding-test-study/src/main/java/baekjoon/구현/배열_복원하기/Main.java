package baekjoon.구현.배열_복원하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st   = new StringTokenizer(br.readLine());

		int             H    = Integer.parseInt(st.nextToken());
		int             W    = Integer.parseInt(st.nextToken());
		int             X    = Integer.parseInt(st.nextToken());
		int             Y    = Integer.parseInt(st.nextToken());

		int[][]         arrB = new int[H + X][W + Y];
		int[][]         arrA = new int[H][W];

		// 배열 B 입력
		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++) {
				arrB[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();

		// 배열 A 복원
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (i >= X && i < H + X && j >= Y && j < W + Y) {

					// 둘다 포함되는 경우
					sb.append((arrB[i][j] - arrA[i - X][j - Y]) + " ");
					arrA[i][j] = arrB[i][j] - arrA[i - X][j - Y];
				} else if (i < X || j < Y) {

					// 한개의 배열에만 포함되는경우
					sb.append(arrB[i][j] + " ");
					arrA[i][j] = arrB[i][j];
				} else {
					// 둘다 포함 안되는 경우는 없다
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
