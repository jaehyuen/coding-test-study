package baekjoon.구현.마법사_상어와_토네이도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 방향별 증감값
	public static int[]    xArr       = { 0, 1, 0, -1 };
	public static int[]    yArr       = { -1, 0, 1, 0 };

	// 방향별 모래가 날리는 순서
	public static int[][]  flyXArr    = { { -1, 1, -2, -1, 1, 2, -1, 1, 0, 0 }, { -1, -1, 0, 0, 0, 0, 1, 1, 2, 1 },
			{ -1, 1, -2, -1, 1, 2, -1, 1, 0, 0 }, { 1, 1, 0, 0, 0, 0, -1, -1, -2, -1 } };
	public static int[][]  flyYArr    = { { 1, 1, 0, 0, 0, 0, -1, -1, -2, -1 }, { -1, 1, -2, -1, 1, 2, -1, 1, 0, 0 },
			{ -1, -1, 0, 0, 0, 0, 1, 1, 2, 1 }, { -1, 1, -2, -1, 1, 2, -1, 1, 0, 0 } };
	public static double[] flyPercent = { (double) 0.01, (double) 0.01, (double) 0.02, (double) 0.07, (double) 0.07,
			(double) 0.02, (double) 0.1, (double) 0.1, (double) 0.05, (double) 0 };

	public static int[][]  map;

	public static int      cnt        = 0;
	public static int      N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N   = Integer.parseInt(br.readLine());

		map = new int[N][N];

		// 모래받 입력
		for (int i = 0; i < N; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x            = N / 2;
		int y            = N / 2;

		int dir          = 0;

		// 방향 변경 카운트
		int dirCnt       = 0;

		// 방향당 최대 이동 카운트
		int moveLimitCnt = 1;

		// 현재 이동 카운트
		int moveCnt      = 0;

		while (true) {

			// 토네이도 소멸
			if (x == 0 && y == 0) {
				break;
			}

			// 모래이동

			// 한방향으로 이동 카운트
			moveCnt++;

			x += xArr[dir];
			y += yArr[dir];

			// 모래가 없으면 넘어감
			if (map[x][y] != 0) {
				moveSand(x, y, dir);
			}

			if (moveCnt == moveLimitCnt) {

				// 방향 전환
				moveCnt = 0;
				dir++;
				dir %= 4;

				dirCnt++;

				// 방향이 2번 변경되면 이동 갯수 증가
				if (dirCnt % 2 == 0) {
					moveLimitCnt++;
				}

			}

		}

		System.out.println(cnt);

	}

	public static void moveSand(int x, int y, int dir) {

		int totalCnt = 0;
		for (int i = 0; i < 10; i++) {

			// 모래가 날릴위치
			int nextX = x + flyXArr[dir][i];
			int nextY = y + flyYArr[dir][i];

			// 마지막 위치면 따로 계산
			if (i == 9) {
				if (nextX < 0 || nextX >= N | nextY < 0 || nextY >= N) {
					cnt       += map[x][y] - totalCnt;
					map[x][y]  = 0;
				} else {

					// 모래 이동
					map[nextX][nextY] += map[x][y] - totalCnt;

					// 현위치 초기화
					map[x][y] = 0;
				}
			} else {
				// 모래가 모래밭밖으로 나가면 카운트 증가
				if (nextX < 0 || nextX >= N | nextY < 0 || nextY >= N) {
					cnt += map[x][y] * flyPercent[i];
				} else {

					// 모래 이동
					map[nextX][nextY] += map[x][y] * flyPercent[i];

				}
				totalCnt += map[x][y] * flyPercent[i];
			}

		}

	}
}
