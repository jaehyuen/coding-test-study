package baekjoon.구현.이차원_배열의_합;

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

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder   sb  = new StringBuilder();
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             M   = Integer.parseInt(st.nextToken());

		int[][]         arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int K = Integer.parseInt(br.readLine());

		for (int t = 0; t < K; t++) {
			st = new StringTokenizer(br.readLine());

			// 좌표 입력
			int  x1  = Integer.parseInt(st.nextToken()) - 1;
			int  y1  = Integer.parseInt(st.nextToken()) - 1;
			int  x2  = Integer.parseInt(st.nextToken()) - 1;
			int  y2  = Integer.parseInt(st.nextToken()) - 1;

			long sum = 0;

			// 값을 더해줌
			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					sum += arr[i][j];
				}
			}

			sb.append(sum + "\n");

		}
		System.out.println(sb.toString());
	}

}
