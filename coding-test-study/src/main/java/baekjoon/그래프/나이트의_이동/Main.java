package baekjoon.그래프.나이트의_이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
//		

		int            T    = Integer.parseInt(br.readLine());

		int[]          yArr = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[]          xArr = { -1, -2, -2, -1, 1, 2, 2, 1 };

		for (int i = 0; i < T; i++) {
			int             I      = Integer.parseInt(br.readLine());

			int[][]         arr    = new int[I][I];

			StringTokenizer st     = new StringTokenizer(br.readLine());
			Queue<Knight>   q      = new LinkedList<Knight>();

			int             startX = Integer.parseInt(st.nextToken());
			int             startY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			q.add(new Knight(startX, startY));
			arr[startX][startY] = 1;

			while (!q.isEmpty()) {

				Knight now = q.poll();

				if (now.x == endX && now.y == endY) {
					break;
				}

				for (int j = 0; j < 8; j++) {
					int nextX = now.x + xArr[j];
					int nextY = now.y + yArr[j];

					if (nextX < 0 || nextX >= I || nextY < 0 || nextY >= I)
						continue;

					if (arr[nextX][nextY] == 0) {
						q.add(new Knight(nextX, nextY));
						arr[nextX][nextY] = arr[now.x][now.y] + 1;

					}
				}
			}

			System.out.println(arr[endX][endY] - 1);

		}

	}
}

class Knight {
	int x;
	int y;

	public Knight(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
