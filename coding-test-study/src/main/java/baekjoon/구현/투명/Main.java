package baekjoon.구현.투명;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] picture = new int[101][101];

		for (int a = 0; a < N; a++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 그림에 카운팅 증가
			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					picture[i][j]++;
				}
			}
		}

		int result = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {

				// 그림이 안보이는지 카운팅
				if (picture[i][j] > M) {
					result++;
				}
			}
		}

		System.out.println(result);

	}
}
