package baekjoon.그래프.Puyo_Puyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static char[][] map = new char[12][6];

	public static int[] xArr = { 1, -1, 0, 0 };
	public static int[] yArr = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 게임 필드 입력
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int total = 0;

		while (true) {
			int cnt = find();

			if (cnt == 0) {
				break;
			}
			
			//연쇄 카운트 증가
			total++;
			move();
		}

		System.out.println(total);
	}

	public static int find() {
		int result = 0;
		boolean[][] v = new boolean[12][6];

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {

				if (!v[i][j] && map[i][j] != '.') {
					Queue<int[]> q = new LinkedList<int[]>();
					ArrayList<int[]> list = new ArrayList<>();

					v[i][j] = true;
					q.add(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] now = q.poll();
						list.add(now);

						for (int k = 0; k < 4; k++) {
							int x = now[0] + xArr[k];
							int y = now[1] + yArr[k];

							// 범위 체크
							if (x < 0 || x >= 12 || y < 0 || y >= 6) {
								continue;
							}

							// 방문을 안했고 같은 색갈이면 큐에 추가
							if (!v[x][y] && map[i][j] == map[x][y]) {
								q.add(new int[] { x, y });
								v[x][y] = true;
							}
						}

					}

					// 4개이상 이어져있으면 연쇄 카운트 증가
					if (list.size() >= 4) {

						// 지워준다
						for (int[] node : list) {
							map[node[0]][node[1]] = '.';
						}
						result++;
					}
				}
			}
		}

		return result;
	}

	public static void move() {

		for (int i = 0; i < 6; i++) {

			int idx = 11;
			for (int j = 11; j >= 0; j--) {

				// 빈칸이 아니면 아래로 내려줌
				if (map[j][i] != '.') {
					map[idx][i] = map[j][i];

					if (idx != j) {
						map[j][i] = '.';
					}
					idx--;
				}
			}

		}

	}
}
