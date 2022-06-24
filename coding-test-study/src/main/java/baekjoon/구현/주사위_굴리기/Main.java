package baekjoon.구현.주사위_굴리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dice = new int[7];

	public static void main(String[] args) throws IOException {

		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st   = new StringTokenizer(br.readLine());

		int             N    = Integer.parseInt(st.nextToken());
		int             M    = Integer.parseInt(st.nextToken());

		int             x    = Integer.parseInt(st.nextToken());
		int             y    = Integer.parseInt(st.nextToken());

		int             K    = Integer.parseInt(st.nextToken());

		int[][]         arr  = new int[N][M];

		// 방향 지정
		int[]           xDir = { 0, 0, 0, -1, 1 };
		int[]           yDir = { 0, 1, -1, 0, 0 };

		// 지도 채우기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {

			int dir   = Integer.parseInt(st.nextToken());
			int nextX = x + xDir[dir];
			int nextY = y + yDir[dir];

			System.out.println("nextX : " + nextX + ", nextY : " + nextY);
			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
				System.out.println("넘어간");
				continue;
			}

			// 주사위 굴리기
			changeDice(dir);

			if (arr[nextX][nextY] != 0) {
				dice[6]           = arr[nextX][nextY];
				arr[nextX][nextY] = 0;
			} else {
				arr[nextX][nextY] = dice[6];
			}

			System.out.println(dice[1]);
			x = nextX;
			y = nextY;
		}

	}

	public static void changeDice(int d) {
		int[] temp = dice.clone();
		// 6 밑면, 1 윗면
		// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
		if (d == 1) {
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
		} else if (d == 2) {
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
		} else if (d == 3) {
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[5] = temp[6];
			dice[6] = temp[2];
		} else {
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[5] = temp[1];
			dice[6] = temp[5];
		}
	}
}
