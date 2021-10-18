package baekjoon.그래프.토마토1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br     = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st     = new StringTokenizer(br.readLine());

		int             M      = Integer.parseInt(st.nextToken());
		int             N      = Integer.parseInt(st.nextToken());

		int[][]         arr    = new int[N][M];

		int[]           xArr   = { 0, 0, 1, -1 };
		int[]           yArr   = { 1, -1, 0, 0 };

		int             toCnt1 = 0;
		int             toCnt2 = 0;
		int             result = 0;

		Queue<Tomato>   queue  = new LinkedList<Tomato>();

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != -1) {
					toCnt1++;
				}
				if (arr[i][j] == 1) {

					queue.add(new Tomato(j, i));
				}
			}

		}

		if (queue.size() == toCnt1) {
			System.out.println(0);
		} else {

			while (!queue.isEmpty()) {
				toCnt2++;
				Tomato tomato = queue.poll();

				for (int i = 0; i < 4; i++) {

					int nextX = tomato.x + xArr[i];
					int nextY = tomato.y + yArr[i];
					if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
						if (arr[nextY][nextX] == 0) {
							queue.add(new Tomato(nextX, nextY));
							arr[nextY][nextX] += arr[tomato.y][tomato.x] + 1;

							result             = Math.max(result, arr[nextY][nextX]);

						}
					}

				}
			}

			if (toCnt1 == toCnt2) {
				System.out.println(result - 1);
			} else {
				System.out.println(-1);
			}
		}

	}
}

class Tomato {
	int x;
	int y;

	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
