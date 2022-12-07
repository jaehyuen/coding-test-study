package baekjoon.그래프.양치기_꿍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] xArr = { 1, -1, 0, 0 };
		int[] yArr = { 0, 0, 1, -1 };

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int vTotCnt = 0;
		int kTotCnt = 0;

		// 영역 입력 -3 : 벽, -2 : 늑대, -1 : 양
		int[][] arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray();

			for (int j = 0; j < C; j++) {
				if (tmp[j] == '#') {
					arr[i][j] = -3;
				} else if (tmp[j] == 'v') {
					arr[i][j] = -2;
				} else if (tmp[j] == 'k') {
					arr[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] <= 0 && arr[i][j] > -3) {
					int vCnt = 0;
					int kCnt = 0;

					// 양, 늑대 카운팅
					if (arr[i][j] == -2) {
						vCnt++;
					}
					if (arr[i][j] == -1) {
						kCnt++;
					}

					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[] { i, j });
					arr[i][j] = 1;

					while (!q.isEmpty()) {
						int[] now = q.poll();

						for (int k = 0; k < 4; k++) {
							int nextX = now[0] + xArr[k];
							int nextY = now[1] + yArr[k];

							if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
								continue;
							}

							if (arr[nextX][nextY] <= 0 && arr[nextX][nextY] > -3) {
								q.add(new int[] { nextX, nextY });
								
								// 양, 늑대 카운팅
								if (arr[nextX][nextY] == -2) {
									vCnt++;
								}
								if (arr[nextX][nextY] == -1) {
									kCnt++;
								}

								
								arr[nextX][nextY] = 1;
							}
						}

					}

					// 살아남은 양, 늑대 카운팅
					if (vCnt >= kCnt) {
						vTotCnt += vCnt;
					} else {
						kTotCnt += kCnt;
					}
				}

			}
		}

		System.out.println(kTotCnt + " " + vTotCnt);
	}

}
