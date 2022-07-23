package baekjoon.구현.나이트_투어;

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

	public static void main(String[] args) throws IOException {
		int[] xArr = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] yArr = { -1, -2, -2, -1, 1, 2, 2, 1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] tmp = br.readLine().toCharArray();
		boolean[][] v = new boolean[6][6];

		// 첫번째 위치 방문체크
		int firstX = tmp[1] - '0' - 1;
		int firstY = tmp[0] - 'A';

		int beforeX = firstX;
		int beforeY = firstY;

		v[beforeX][beforeY] = true;

		for (int i = 0; i < 35; i++) {
			tmp = br.readLine().toCharArray();

			int nowX = tmp[1] - '0' - 1;
			int nowY = tmp[0] - 'A';

			if (v[nowX][nowY]) {
				System.out.println("Invalid");
				return;
			}
			v[nowX][nowY] = true;

			boolean flag = false;

			for (int j = 0; j < 8; j++) {

				int nextX = beforeX + xArr[j];
				int nextY = beforeY + yArr[j];

				// 방문 확인 및 가능한 위치인지 확인
				if (nextX < 0 || nextX >= 6 || nextY < 0 || nextY >= 6) {
					continue;
				}

				if (nowX == nextX && nowY == nextY) {
					flag = true;
					break;

				}

			}

			if (!flag) {
				System.out.println("Invalid");
				return;
			}
			beforeX = nowX;
			beforeY = nowY;

		}

		// 첫번쨰 위치로 돌아갈수 있는지 체크
		for (int j = 0; j < 8; j++) {

			int nextX = beforeX + xArr[j];
			int nextY = beforeY + yArr[j];

			if (nextX < 0 || nextX >= 6 || nextY < 0 || nextY >= 6) {
				continue;
			}

			if (firstX == nextX && firstY == nextY) {
				System.out.println("Valid");
				return;

			}

		}

		System.out.println("Invalid");
	}

}
