package baekjoon.그래프.경쟁적_전염;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		int[] xArr = { 1, -1, 0, 0 };
		int[] yArr = { 0, 0, 1, -1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][N];
		int[][] v = new int[N][N];

		// 우선 순위 큐 생성
		// arr[0] = x좌표
		// arr[1] = y좌표
		// arr[2] = 전염된 시간
		// arr[3] = 바이러스 종류
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> {
			if (o1[2] == o2[2]) {
				return o1[3] - o2[3];
			} else {
				return o1[2] - o2[2];
			}

		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {

				// 배열 및 방문시간 -1로 초기화
				arr[i][j] = Integer.parseInt(st.nextToken());
				v[i][j] = -1;

				// 이미 바이러스가 있다면 큐에 등록
				if (arr[i][j] != 0) {
					v[i][j] = 0;
					q.add(new int[] { i, j, 0, arr[i][j] });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = now[0] + xArr[i];
				int y = now[1] + yArr[i];

				// 범위 체크
				if (x < 0 || x >= N || y < 0 || y >= N) {
					continue;
				}

				// 전염 안됫으면 전염
				if (v[x][y] == -1) {
					v[x][y] = now[2] + 1;
					arr[x][y] = now[3];
					q.add(new int[] { x, y, v[x][y], arr[x][y] });
				}
			}

		}
		st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		// 주어진 시간보다 전염된 시간이 더 크면 0 출력
		if (v[X - 1][Y - 1] > S) {
			System.out.println(0);
		} else {
			System.out.println(arr[X - 1][Y - 1]);
		}

	}

}
