package baekjoon.구현.어두운_굴다리;

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

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int now = 0;
		int prev = 0;
		int min = 0;
		for (int i = 0; i < M; i++) {

			now = Integer.parseInt(st.nextToken());

			// 첫번쨰 가로등이면 그위치가 최소값이다
			if (i == 0) {
				min = now;
			} else {
				min = (int) Math.max(min, Math.ceil( (now - prev) / 2d));
			}
			prev = now;
		}

		min = Math.max(min, N - prev);

		System.out.println(min);

	}
}
