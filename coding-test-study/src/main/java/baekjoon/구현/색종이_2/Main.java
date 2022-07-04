package baekjoon.구현.색종이_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[][] v = new boolean[100][100];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			// 색종이를 붙여준다
			for (int j = tmp1; j < tmp1 + 10; j++) {
				for (int k = tmp2; k < tmp2 + 10; k++) {
					v[j][k] = true;
				}

			}

		}

		int[] xDir = { 1, -1, 0, 0 };
		int[] yDir = { 0, 0, 1, -1 };

		int cnt = 0;
		// 둘레 체크
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {

				// 색종이가 붙은 경우
				if (v[i][j]) {
					for (int k = 0; k < 4; k++) {
						int nextX = i + xDir[k];
						int nextY = j + yDir[k];

						// 범위를 벗어나면 둘레에 추가
						if (nextX < 0 || nextX >= 100 || nextY < 0 || nextY >= 100)
							cnt++;

						// 종이가 아닐경우 둘레에 추가
						else if (!v[nextX][nextY])
							cnt++;
					}

				}

			}
		}

		System.out.println(cnt);

	}
}
