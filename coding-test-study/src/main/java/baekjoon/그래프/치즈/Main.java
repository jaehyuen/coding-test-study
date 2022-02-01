package baekjoon.그래프.치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] cheeze;

	static int[] xArr = { 1, -1, 0, 0 };
	static int[] yArr = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cheeze = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				cheeze[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int idx = 0;
		int cnt = 100;
		int prevCnt = 100;
		while (true) {

			prevCnt = cnt;
			cnt = move();

			if (cnt == 0) {
				System.out.println(idx);
				System.out.println(prevCnt);
				
				break;
			}
			idx++;
		}

	}

	public static int move() {
		boolean[][] v = new boolean[N + 1][M + 1];

		int cnt = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0 });
		v[0][0] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int k = 0; k < 4; k++) {
				int nextX = now[0] + xArr[k];
				int nextY = now[1] + yArr[k];

				if (nextX < 0 || nextX > N || nextY < 0 || nextY > M)
					continue;

				if (!v[nextX][nextY] && cheeze[nextX][nextY] != 1) {
					q.add(new int[] { nextX, nextY });
					v[nextX][nextY] = true;
					cheeze[nextX][nextY] = 0;
				} else if (!v[nextX][nextY] && cheeze[nextX][nextY] == 1) {
					v[nextX][nextY] = true;
					cheeze[nextX][nextY] = 2;
					cnt++;
				}

			}
		}

//		for (int[] ch : cheeze) {
//			System.out.println(Arrays.toString(ch));
//		}
//		System.out.println(cnt);

		return cnt;

	}

}
