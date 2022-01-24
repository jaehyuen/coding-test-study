package baekjoon.그래프.침투;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st   = new StringTokenizer(br.readLine());

		int             N    = Integer.parseInt(st.nextToken());
		int             M    = Integer.parseInt(st.nextToken());

		char[][]        arr  = new char[N][M];
		boolean[][]     v    = new boolean[N][M];

		int[]           xArr = { 0, 0, 1, -1 };
		int[]           yArr = { 1, -1, 0, 0 };

		for (int i = 0; i < N; i++) {
			char[] str = br.readLine()
				.toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str[j];
			}
		}

		for (int i = 0; i < M; i++) {
			if (arr[0][i] == '0' && !v[0][i]) {
				Queue<int[]> q = new LinkedList<int[]>();
				q.add(new int[] { 0, i });
				v[0][i] = true;

				while (!q.isEmpty()) {
					int[] now = q.poll();

					for (int j = 0; j < 4; j++) {
						int nextX = now[0] + xArr[j];
						int nextY = now[1] + yArr[j];

						if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
							continue;

						if (arr[nextX][nextY] == '0' && !v[nextX][nextY]) {
							q.add(new int[] { nextX, nextY });
							v[nextX][nextY] = true;
						}
					}
				}
			}

		}
		String result = "NO";
		for (boolean b : v[N - 1]) {
			if (b) {
				result = "YES";
				break;
			}
		}
		System.out.println(result);

	}
}
