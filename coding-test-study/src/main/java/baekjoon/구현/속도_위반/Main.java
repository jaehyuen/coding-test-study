package baekjoon.구현.속도_위반;

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

		int[][] limit = new int[N][2];
		int distance = 0;

		// 제한 속도 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			distance += Integer.parseInt(st.nextToken());

			limit[i][0] = distance;
			limit[i][1] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int idx = 0;
		distance = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			// 거리 증감
			distance += Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());

			// 속도 위반 검사
			if (limit[idx][0] >= distance) {
				max = Math.max(max, speed - limit[idx][1] < 0 ? 0 : speed - limit[idx][1]);
			}

			// 구간 변경
			while (idx < N && limit[idx][0] <= distance) {
				max = Math.max(max, speed - limit[idx][1] < 0 ? 0 : speed - limit[idx][1]);
				idx++;
			}
		}

		System.out.println(max);

	}
}
