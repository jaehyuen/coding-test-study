package baekjoon.그래프.점프점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));

		int             n   = Integer.parseInt(br.readLine());

		int[]           arr = new int[n];
		boolean[]       v   = new boolean[n];
		StringTokenizer st  = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int            s = Integer.parseInt(br.readLine()) - 1;

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		v[s] = true;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < 2; i++) {
				int next;
				// 점프
				if (i == 0) {
					next = now + arr[now];
				} else {
					next = now - arr[now];
				}

				// 범위 체크
				if (next < 0 || next >= n) {
					continue;
				}

				// 큐에 넣어줌
				if (!v[next]) {
					q.add(next);
					v[next] = true;
				}
			}
		}

		// 방문한 지역 체크
		int cnt = 0;
		for (boolean b : v) {
			if (b) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
