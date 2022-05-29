package baekjoon.그래프.연구소_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[]            xArr = { 1, -1, 0, 0 };
	static int[]            yArr = { 0, 0, 1, -1 };

	static ArrayList<int[]> list = new ArrayList<>();
	static int[][]          arr1;
	static int[][]          arr2;

	static int              N;
	static int              M;
	static int              totalCnt;

	static int              min  = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N        = Integer.parseInt(st.nextToken());
		M        = Integer.parseInt(st.nextToken());

		arr1     = new int[N][N];
		arr2     = new int[M][2];
		totalCnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());

				// 총 빈칸 갯수 저장
				if (arr1[i][j] == 0)
					totalCnt++;

				// 바이러스 저장
				if (arr1[i][j] == 2)
					list.add(new int[] { i, j });

			}
		}

		find(0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

	public static void find(int idx, int start) {
		if (idx == M) {

			bfs();
			return;
		}
		for (int i = start; i < list.size(); i++) {

			arr2[idx] = list.get(i);
			find(idx + 1, i + 1);
		}

	}

	public static void bfs() {

		Queue<int[]> q   = new LinkedList<int[]>();

		int[][]      map = new int[N][N];

		// 활성화할 바이러스 큐에 등록
		for (int[] a : arr2) {
			q.add(a);
			map[a[0]][a[1]] = 1;
		}

		// 감염 카운트
		int cnt = 0;
		int max = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			// 감염자면 최대값 갱신
			if (arr1[now[0]][now[1]] == 0) {
				max = Math.max(max, map[now[0]][now[1]]);

			}

			for (int i = 0; i < 4; i++) {
				int nextX = now[0] + xArr[i];
				int nextY = now[1] + yArr[i];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
					continue;

				// 감염자 추가
				if (map[nextX][nextY] == 0 && arr1[nextX][nextY] != 1) {

					// 빈칸일떄만 카운트 증가
					if (arr1[nextX][nextY] == 0) {
						cnt++;

					}

					map[nextX][nextY] = map[now[0]][now[1]] + 1;
					q.add(new int[] { nextX, nextY });

				}

			}
		}

		// 모두 감염되면 값 갱신
		if (cnt == totalCnt) {

			// 최소값 갱신
			min = Math.min(min, max == 0 ? max : max - 1);
		}

	}
}
