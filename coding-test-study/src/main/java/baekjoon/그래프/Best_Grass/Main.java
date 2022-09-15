package baekjoon.그래프.Best_Grass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		int[]           xArr = { 1, 0 };
		int[]           yArr = { 0, 1 };

		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st   = new StringTokenizer(br.readLine());

		int             R    = Integer.parseInt(st.nextToken());
		int             C    = Integer.parseInt(st.nextToken());

		char[][]        map  = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine()
				.toCharArray();

		}

		int cnt = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				// 건초더미면 카운트 중가
				if (map[i][j] == '#') {
					cnt++;
					map[i][j] = '.';

					// 혹시나 이어져 있는지 체크
					for (int k = 0; k < 2; k++) {
						int nextX = i + xArr[k];
						int nextY = j + yArr[k];

						if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)
							continue;

						if (map[nextX][nextY] == '#') {
							map[nextX][nextY] = '.';
							break;
						}

					}

				}
			}
		}

		System.out.println(cnt);

	}

}
