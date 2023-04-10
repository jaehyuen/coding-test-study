package baekjoon.그래프.불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[]          xArr = { 1, -1, 0, 0 };
		int[]          yArr = { 0, 0, 1, -1 };

		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
		int            T    = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st         = new StringTokenizer(br.readLine());

			int             w          = Integer.parseInt(st.nextToken());
			int             h          = Integer.parseInt(st.nextToken());

			char[][]        map        = new char[h + 2][w + 2];
			int[][]         v          = new int[h + 2][w + 2];

			Queue<int[]>    q          = new LinkedList<int[]>();

			// 상근이 위치
			int[]           sgLocation = new int[2];

			for (int j = 1; j <= h; j++) {
				String tmp = br.readLine();
				for (int k = 1; k <= w; k++) {

					map[j][k] = tmp.charAt(k - 1);

					// 불이면 큐에 추가
					if (map[j][k] == '*') {
						q.add(new int[] { j, k });
						v[j][k] = 1;
					} else if (map[j][k] == '@') {
						sgLocation[0] = j;
						sgLocation[1] = k;
					}
				}
			}

			// 불의 이동 경로 계산
			while (!q.isEmpty()) {
				int[] now = q.poll();

				for (int j = 0; j < 4; j++) {
					int x = now[0] + xArr[j];
					int y = now[1] + yArr[j];

					if (x < 1 || x >= h + 1 || y < 1 || y >= w + 1) {
						continue;
					}

					// 벽이 아니면서 방문 안햇으면 불이 번진다
					if (map[x][y] != '#' && v[x][y] == 0) {
						q.add(new int[] { x, y });
						v[x][y] = v[now[0]][now[1]] + 1;
					}
				}
			}

			int[][] sgV = new int[h + 2][w + 2];
			q.clear();
			q.add(sgLocation);

			sgV[sgLocation[0]][sgLocation[1]] = 1;
			int result = -1;

			// 상근이의 이동 경로 계산
			while (!q.isEmpty()) {
				int[] now = q.poll();

				// 맵 밖으로 벗어나면 탈출
				if (now[0] < 1 || now[0] >= h + 1 || now[1] < 1 || now[1] >= w + 1) {
					result = sgV[now[0]][now[1]];
					break;
				}

				for (int j = 0; j < 4; j++) {
					int x = now[0] + xArr[j];
					int y = now[1] + yArr[j];

					if (x < 0 || x >= h + 2 || y < 0 || y >= w + 2) {
						continue;
					}

					// 벽이 아니면서 방문 안햇으면서 불보다 빨리왓을떄
					if (map[x][y] != '#' && sgV[x][y] == 0 && (sgV[now[0]][now[1]] + 1 < v[x][y] || v[x][y] == 0)) {
						q.add(new int[] { x, y });
						sgV[x][y] = sgV[now[0]][now[1]] + 1;
					}
				}
			}

			if (result == -1) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(result - 1);
			}
		}
	}

}