package baekjoon.구현.달팽이;

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
		int K = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];
		int cnt = N * N;
		int rowN = N;
		int colN = N;

		int x = -1;
		int y = 0;

		// 달팽이 배열 생성
		while (cnt > 0) {

			for (int i = 0; i < rowN; i++) {
				arr[++x][y] = cnt--;
			}
			colN--;

			for (int i = 0; i < colN; i++) {
				arr[x][++y] = cnt--;
			}
			rowN--;

			for (int i = 0; i < rowN; i++) {
				arr[--x][y] = cnt--;
			}
			colN--;
			for (int i = 0; i < colN; i++) {
				arr[x][--y] = cnt--;
			}
			rowN--;

		}

		int targetX = 0;
		int targetY = 0;

		StringBuilder sb = new StringBuilder();
		// 배열을 출력 하면서 타겟 위치를 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				sb.append(arr[i][j] + " ");

				if (arr[i][j] == K) {
					targetX = i + 1;
					targetY = j + 1;
				}
			}
			sb.append("\n");
		}
		sb.append(targetX + " " + targetY);

		System.out.println(sb.toString());

	}
}
