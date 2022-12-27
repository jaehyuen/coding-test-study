package baekjoon.구현.돌다리;

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

		int             A   = Integer.parseInt(st.nextToken());
		int             B   = Integer.parseInt(st.nextToken());

		int             N   = Integer.parseInt(st.nextToken());
		int             M   = Integer.parseInt(st.nextToken());

		int[]           v   = new int[100001];

		// 증감값 설정
		int[]           arr = new int[] { 1, -1, A, B, -A, -B };

		// 시작 위치 추가
		Queue<Integer>  q   = new LinkedList<Integer>();
		q.add(N);
		v[N] = 1;

		while (v[M] == 0) {
			int now = q.poll();

			for (int i = 0; i < 8; i++) {
				int next;

				// 6 이상이면 곱하기 아니면 증감값 더하기
				if (i == 6) {
					next = now * A;
				} else if (i == 7) {
					next = now * B;
				} else {
					next = now + arr[i];
				}

				// 범위체크
				if (next < 0 || next > 100000) {
					continue;
				}

				// 방문 체크
				if (v[next] == 0) {
					q.add(next);
					v[next] = v[now] + 1;
				}

			}
		}
		System.out.println(v[M] - 1);

	}

}
