package baekjoon.구현.로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		int[] xArr = { 0, -1, 0, 1 };
		int[] yArr = { 1, 0, -1, 0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int nowX = 0;
		int nowY = 0;

		int dir = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String func = st.nextToken();
			int value = Integer.parseInt(st.nextToken());

			if (func.equals("MOVE")) {
				int nextX = nowX + (xArr[dir] * value);
				int nextY = nowY + (yArr[dir] * value);

				// 범위에 벗어나면 유효하지 않음
				if (nextX < 0 || nextX > M || nextY < 0 || nextY > M) {
					System.out.println(-1);
					return;
				}

				// 위치 수정
				nowX = nextX;
				nowY = nextY;

			} else {

				if (value == 1) {
					// 오른쪽 회전
					dir++;
					dir %= 4;

				} else {
					// 왼쪽 회전

					dir--;

					if (dir == -1) {
						dir = 3;
					}

				}

			}
			//System.out.println(nowX + " " + nowY + " " + dir);

		}
		System.out.println(nowY + " " + nowX);

	}
}
