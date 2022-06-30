package baekjoon.구현.지구_온난화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader   br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st   = new StringTokenizer(br.readLine());

		int              R    = Integer.parseInt(st.nextToken());
		int              C    = Integer.parseInt(st.nextToken());

		int[][]          map  = new int[R][C];
		ArrayList<int[]> list = new ArrayList<int[]>();

		for (int i = 0; i < R; i++) {

			char[] arr = br.readLine()
				.toCharArray();

			for (int j = 0; j < C; j++) {

				if (arr[j] == 'X') {
					list.add(new int[] { i, j });
					map[i][j] = 1;

				} else {
					map[i][j] = 0;
				}
			}
		}

		int[] xdir = { 1, -1, 0, 0 };
		int[] ydir = { 0, 0, 1, -1 };

		int   minX = Integer.MAX_VALUE;
		int   maxX = Integer.MIN_VALUE;
		int   minY = Integer.MAX_VALUE;
		int   maxY = Integer.MIN_VALUE;

		for (int[] land : list) {

			int cnt = 0;

			// 주변이 바다인지 체크
			for (int i = 0; i < 4; i++) {
				int nextX = land[0] + xdir[i];
				int nextY = land[1] + ydir[i];

				if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
					cnt++;
				} else if (map[nextX][nextY] == 0) {
					cnt++;
				}
			}

			// 3면 이상이 바다면 잠긴다
			if (cnt > 2) {
				map[land[0]][land[1]] = 2;
			} else {
				// 섬의 끝위치 구하기
				minX = Math.min(minX, land[0]);
				maxX = Math.max(maxX, land[0]);
				minY = Math.min(minY, land[1]);
				maxY = Math.max(maxY, land[1]);
			}

		}

		// 지도를 줄여서 출력
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				if (map[i][j] == 1) {
					System.out.print("X");
				} else {
					System.out.print(".");
				}

			}
			System.out.println();
		}

	}
}
