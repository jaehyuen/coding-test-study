package baekjoon.그래프.폴짝폴짝;

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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] map = new int[N];
		int[] v = new int[N];

		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<Integer>();

		// 시작지점 추가
		v[a - 1] = 1;
		q.add(a - 1);

		while (!q.isEmpty()) {
			int now = q.poll();

			if (v[b - 1] != 0) {
				break;
			}

			// 현재 위치에서 오른쪽으로 갈 수 있는 징겅다리를 지나감
			for (int i = now; i < N; i += map[now]) {

				if (v[i] == 0) {
					q.add(i);
					v[i] = v[now] + 1;
				}

			}

			// 현재 위치에서 왼쪽으로 갈 수 있는 징겅다리를 지나감
			for (int i = now; i >= 0; i -= map[now]) {

				if (v[i] == 0) {
					q.add(i);
					v[i] = v[now] + 1;
				}

			}
		}

		System.out.println(v[b - 1] - 1);

	}

}
