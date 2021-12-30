package baekjoon.DP.이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int[]           xArr = { 0, -1, -1 };
		int[]           yArr = { -1, 0, -1 };

		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st   = new StringTokenizer(br.readLine());

		int             N    = Integer.parseInt(st.nextToken());
		int             M    = Integer.parseInt(st.nextToken());

		int[][]         arr  = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				int tmp = Integer.parseInt(st.nextToken());

				arr[i][j] = tmp;

				for (int k = 0; k < 3; k++) {
					int nextX = i + xArr[k];
					int nextY = j + yArr[k];

					if (nextX < 1 || nextX > N || nextY < 1 || nextY > M)
						continue;

					arr[i][j] = Math.max(tmp + arr[nextX][nextY], arr[i][j]);

				}

			}
		}

		System.out.println(arr[N][M]);

	}

}