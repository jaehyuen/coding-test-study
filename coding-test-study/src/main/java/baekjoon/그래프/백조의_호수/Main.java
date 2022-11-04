package baekjoon.그래프.백조의_호수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int[] xArr = { 1, -1, 0, 0 };
	public static int[] yArr = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader  br      = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st      = new StringTokenizer(br.readLine());
		int             R       = Integer.parseInt(st.nextToken());
		int             C       = Integer.parseInt(st.nextToken());

		// 지도
		char[][]        map     = new char[R][C];

		// 방문 체크 배열
		int[][]         v       = new int[R][C];

		// 백조 위치
		int[][]         bird    = new int[2][2];

		int             birdCnt = 0;

		Queue<int[]>    water   = new LinkedList<int[]>();
		Queue<int[]>    q1      = new LinkedList<int[]>();

		for (int i = 0; i < R; i++) {
			char[] tmp = br.readLine()
				.toCharArray();
			map[i] = tmp;
			for (int j = 0; j < C; j++) {

				if (tmp[j] == 'L') {
					bird[birdCnt][0] = i;
					bird[birdCnt][1] = j;
					birdCnt++;

				}
				if (tmp[j] != 'X') {
					// 물이면 물 큐에 추가
					water.add(new int[] { i, j });

				}
			}
		}

		// 백조를 출발시킨다
		q1.add(new int[] { bird[0][0], bird[0][1] });
		v[bird[0][0]][bird[0][1]] = 1;

		int     cnt  = 0;
		boolean flag = false;

		while (true) {
			Queue<int[]> q2 = new LinkedList<int[]>();

			while (!q1.isEmpty()) {
				int[] now = q1.poll();

				// 백조를 만날시 종료
				if (now[0] == bird[1][0] && now[1] == bird[1][1]) {
					flag = true;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nextX = now[0] + xArr[i];
					int nextY = now[1] + yArr[i];

					if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C || v[nextX][nextY] == 1) {
						continue;
					}
					v[nextX][nextY] = 1;

					// 물에 인접한 얼음이면 다음번 큐에 추가
					if (map[nextX][nextY] == 'X') {
						q2.add(new int[] { nextX, nextY });

					} else {
						// 지금 탐색 가능한곳
						q1.add(new int[] { nextX, nextY });
					}

				}
			}

			// 백조르 찾으면
			if (flag) {
				break;
			}

			q1 = q2;

			// 얼음을 녹인다.
			int size = water.size();

			for (int i = 0; i < size; i++) {
				int[] now = water.poll();

				for (int j = 0; j < 4; j++) {
					int nextX = now[0] + xArr[j];
					int nextY = now[1] + yArr[j];

					if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
						continue;
					}

					// 물에 인접한 얼음을 발견하면 녹이고 다시 큐에 넣는다.
					if (map[nextX][nextY] == 'X') {
						map[nextX][nextY] = '.';
						water.add(new int[] { nextX, nextY });
					}
				}
			}
			cnt++;

		}
		System.out.println(cnt);

	}

}
