package baekjoon.그래프.마법사_상어와_비바라기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static int[] xDir = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	public static int[] yDir = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	public static int N;
	public static int M;

	public static int[][] map;

	public static ArrayList<Integer> cloudList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 구름 세팅
		cloudList.add((N * (N - 1)));
		cloudList.add((N * (N - 1)) + 1);
		cloudList.add((N * (N - 2)));
		cloudList.add((N * (N - 2)) + 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			// 구름이동, 비, 물복사 메소드
			moveCloudAndRainAndCopy(d, s);

			// 구름 생성
			createCloud();

		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}

		System.out.println(sum);

	}

	public static void createCloud() {

		ArrayList<Integer> newCloudList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// 물이 2이상 있는지 체크
				if (map[i][j] >= 2) {

					int idx = (i * N) + j;

					// 이전에 구름이 있던곳이 아니면 구름을 생성
					if (!cloudList.contains(idx)) {
						newCloudList.add(idx);
						map[i][j] -= 2;
					}

				}
			}
		}

		cloudList = newCloudList;

	}

	public static void moveCloudAndRainAndCopy(int dir, int cnt) {
		ArrayList<Integer> newCloudList = new ArrayList<>();

		for (int cloud : cloudList) {

			int beforeX = cloud / N;
			int beforeY = cloud % N;

			// 구름 이동
			int x = checkRange(beforeX + (xDir[dir] * cnt));
			int y = checkRange(beforeY + (yDir[dir] * cnt));

			// 이동된 위치에 비내림
			map[x][y]++;

			newCloudList.add((x * N) + y);

		}

		for (int cloud : newCloudList) {

			int x = cloud / N;
			int y = cloud % N;

			// 물 복사 시작
			int waterCnt = 0;
			for (int i = 2; i <= 8; i += 2) {
				int nextX = x + xDir[i];
				int nextY = y + yDir[i];

				// 범위 체크
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
					continue;
				}

				// 물카운트 증가
				if (map[nextX][nextY] > 0) {
					waterCnt++;
				}

			}
			map[x][y] += waterCnt;

		}

		cloudList = newCloudList;
	}

	public static int checkRange(int i) {

		while (true) {

			// i가 음수면 N - i 절대값을 해서 범위를 설정
			if (i < 0) {
				i = N - (int) Math.abs(i);
			} else if (i >= N) {
				return i % N;
			} else {
				return i;
			}
		}

	}

}
