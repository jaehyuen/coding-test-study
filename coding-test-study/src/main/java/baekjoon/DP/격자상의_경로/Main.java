package baekjoon.DP.격자상의_경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             N  = Integer.parseInt(st.nextToken());
		int             M  = Integer.parseInt(st.nextToken());
		int             K  = Integer.parseInt(st.nextToken());
		if (K == 0) {
			int[][] arr = new int[N + 1][M + 1];

			// dp로 구한다
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					arr[i][j] = Math.max(1, arr[i - 1][j] + arr[i][j - 1]);
				}
			}

			System.out.println(arr[N][M]);
			return;
		} else {

			int     x    = 0;
			int     y    = 0;
			int     cnt  = 0;

			// k까지의 값을 구한다
			int[][] arr1 = new int[N + 1][M + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					arr1[i][j] = Math.max(1, arr1[i - 1][j] + arr1[i][j - 1]);
					cnt++;

					// k 위치에 도달하면 x, y 를 저장하고 반복 종료
					if (cnt == K) {
						x = i;
						y = j;
						break;
					}
				}

				if (cnt >= K) {
					break;
				}
			}

			// k부터 끝까지 값을 구한다
			int[][] arr2 = new int[N + 1][M + 1];

			for (int i = x; i <= N; i++) {
				for (int j = y; j <= M; j++) {
					arr2[i][j] = Math.max(1, arr2[i - 1][j] + arr2[i][j - 1]);
				}
			}

			// 두 값을 곱한다
			System.out.println(arr1[x][y] * arr2[N][M]);
		}

	}
}