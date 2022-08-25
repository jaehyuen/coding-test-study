package baekjoon.구현.죽음의_게임;

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
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             K   = Integer.parseInt(st.nextToken());

		int[]           arr = new int[N];
		boolean[]       v   = new boolean[N];

		// 지목 리스트 추가
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 0;
		int now = 0;

		while (true) {

			// 카운트 증가
			cnt++;

			// 방문체크
			v[now] = true;

			// 목표에 도달하면 그만
			if (now == K) {
				System.out.println(cnt - 1);
				return;
			}

			// 다음 차레로 변경
			now = arr[now];

			// 방문했으면 불가능 출력
			if (v[now]) {
				System.out.println(-1);
				return;
			}

		}
	}
}
