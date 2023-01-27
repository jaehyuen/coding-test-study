package baekjoon.구현.꽃길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int[] flowerArr = new int[3];
	public static int[][] map;

	public static int[] xArr = { 0, 0, 1, -1 };
	public static int[] yArr = { 1, -1, 0, 0 };

	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		find(0, 0);
		System.out.println(min);

	}

	public static void find(int idx, int start) {

		// 심을곳 3곳이 정해지면 가격 체크
		if (idx == 3) {
			check();
			return;
		}

		for (int i = start; i < N * N; i++) {
			flowerArr[idx] = i;
			find(idx + 1, i + 1);
		}
	}

	public static void check() {
		int[][] v = new int[N][N];
		int[] costArr = new int[3];

		for (int i = 0; i < 3; i++) {

			int nowX = flowerArr[i] / N;
			int nowY = flowerArr[i] % N;

			// 씨앗 땅비용 중가
			costArr[i] += map[nowX][nowY];
			v[nowX][nowY] = i + 1;

			for (int j = 0; j < 4; j++) {
				int x = nowX + xArr[j];
				int y = nowY + yArr[j];

				// 땅 범위를 벗어나면 꽃은 죽는다
				if (x < 0 || x >= N || y < 0 || y >= N) {
					costArr[i] = -1;
					break;
				}

				// 겹침 체크
				if (v[x][y] != 0) {
					costArr[i] = -1;
					costArr[v[x][y] - 1] = -1;
					break;
				}

				// 꽃잎 땅비용 중가
				costArr[i] += map[x][y];
				v[x][y] = i + 1;

			}

		}
		boolean flag = true;
		int sum = 0;

		// 겹쳐서 죽는지 체크
		for (int cost : costArr) {
			if (cost == -1) {
				flag = false;
				break;
			}
			sum += cost;

		}

		// 꽃 3개가 살아있으면 최소값 갱신
		if (flag) {
			min = Math.min(sum, min);
		}

	}
}
