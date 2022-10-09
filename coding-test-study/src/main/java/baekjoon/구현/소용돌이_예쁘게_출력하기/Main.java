package baekjoon.구현.소용돌이_예쁘게_출력하기;

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
	static int r1;
	static int c1;
	static int r2;
	static int c2;

	static int xLength;
	static int yLength;

	static int[][] arr;

	static int totalCnt = 0;
	static int max = 0;

	public static void main(String[] args) throws IOException {

		int[] xArr = { -1, 0, 1, 0 };
		int[] yArr = { 0, -1, 0, 1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		xLength = Math.abs(r2 - r1 + 1);
		yLength = Math.abs(c2 - c1 + 1);
		arr = new int[xLength][yLength];

		int nowX = 0;
		int nowY = 0;
		int cnt = 1;
		int tmp = 2;

		chechLocation(nowX, nowY++, cnt);
		while (true) {

			// 출려할 부분을 전부 채웟으면 종료
			if (totalCnt >= xLength * yLength) {
				break;
			}

			// 4방향을 돌며 달팽이 배열을 그린다
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < tmp; j++) {

					// 출력할 배열에 속해있는지 확인
					chechLocation(nowX, nowY, ++cnt);

					// 방향 증감
					nowX += xArr[i];
					nowY += yArr[i];
				}

				// 방항별 자리 조정
				if (i == 0) {
					nowX++;
					nowY--;
				} else if (i == 1) {
					nowX++;
					nowY++;
				} else if (i == 2) {
					nowX--;
					nowY++;
				}

			}
			tmp += 2;

		}

		// 최대값의 자리수에 맞게 출력형식 변경
		for (int[] ar : arr) {
			for (int a : ar) {
				System.out.print(String.format("%" + String.valueOf(max).length() + "d", a) + " ");
			}
			System.out.println();
		}

	}

	public static boolean chechLocation(int nowX, int nowY, int cnt) {

		// 출력 위치에 속하는지 판단
		if (nowX >= r1 && nowX <= r2 && nowY >= c1 && nowY <= c2) {

			// 배열 위치 파악
			int x = Math.abs(r1 - nowX);
			int y = Math.abs(c1 - nowY);

			// 값 저장
			arr[x][y] = cnt;

			// 찾은 갯수 증가
			totalCnt++;

			// 최대값 설정
			max = Math.max(max, cnt);

			return true;
		}
		return false;
	}
}
