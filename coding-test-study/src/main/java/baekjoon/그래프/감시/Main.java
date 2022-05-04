package baekjoon.그래프.감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;

	// cctv 정보 [0] = x, [1] = y, [2] = cctv 종류, [4] = cctv 방향
	static ArrayList<int[]> cctvList = new ArrayList<>();

	// cctv 방향 정보 cctv 종류, 방향, 증감값
	static int[][][] xDir = { { { 1 }, { -1 }, { 0 }, { 0 } }, { { 1, -1 }, { 0, 0 } },
			{ { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }, { { 1, 0, -1 }, { 0, 1, 0 }, { -1, 0, 1 }, { 0, -1, 0 } },
			{ { 1, -1, 0, 0 } } };
	static int[][][] yDir = { { { 0 }, { 0 }, { 1 }, { -1 } }, { { 0, 0 }, { 1, -1 } },
			{ { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }, { { 0, -1, 0 }, { 1, 0, -1 }, { 0, 1, 0 }, { -1, 0, 1 } },
			{ { 0, 0, 1, -1 } } };

	static int[][] office;
	static int[][] dOffice;

	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		office = new int[N][M];

		// 사무실 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] != 0 && office[i][j] != 6) {
					cctvList.add(new int[] { i, j, office[i][j] - 1, 0 });
				}

			}
		}

		find(0);
		System.out.println(min);
	}

	public static void find(int idx) {
		if (idx == cctvList.size()) {

			// 배열 복사
			dOffice = new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(office[i], 0, dOffice[i], 0, office[i].length);
			}

			for (int[] cctv : cctvList) {

				// dfs로 감시지역 탐색
				for (int i = 0; i < xDir[cctv[2]][cctv[3]].length; i++) {
					dfs(cctv[0], cctv[1], xDir[cctv[2]][cctv[3]][i], yDir[cctv[2]][cctv[3]][i]);
				}

			}

			// 사각지대 카운팅
			count();

			return;

		}
		int[] cctv = cctvList.get(idx);
		for (int i = 0; i < xDir[cctv[2]].length; i++) {
			cctv[3] = i;
			cctvList.set(idx, cctv);
			find(idx + 1);

		}

	}

	public static void dfs(int x, int y, int xDir, int yDir) {
		int nextX = x + xDir;
		int nextY = y + yDir;

		if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
			return;
		}

		if (dOffice[nextX][nextY] != 6) {
			if (dOffice[nextX][nextY] == 0) {
				// 감시구역 설정
				dOffice[nextX][nextY] = -1;
			}

			dfs(nextX, nextY, xDir, yDir);
		}

	}

	public static void count() {
		int cnt = 0;

		// 사각지대 카운트

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {
				if (dOffice[i][j] == 0) {
					cnt++;

				}
			}
		}

		min = Math.min(cnt, min);
	}

}
