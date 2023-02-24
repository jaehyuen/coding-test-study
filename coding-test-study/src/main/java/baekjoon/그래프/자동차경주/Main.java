package baekjoon.그래프.자동차경주;

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
		BufferedReader                br      = new BufferedReader(new InputStreamReader(System.in));
		int                           N       = Integer.parseInt(br.readLine());
		int                           M       = Integer.parseInt(br.readLine());

		int[]                         roadCnt = new int[N + 1];
		int[]                         point   = new int[N + 1];
		int[]                         parent  = new int[N + 1];

		ArrayList<ArrayList<int[]>>   road    = new ArrayList<ArrayList<int[]>>();
		ArrayList<ArrayList<Integer>> tmp     = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <= N; i++) {
			road.add(new ArrayList<int[]>());
			tmp.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int             p  = Integer.parseInt(st.nextToken());
			int             q  = Integer.parseInt(st.nextToken());
			int             r  = Integer.parseInt(st.nextToken());

			// 경로 연결 카운팅
			roadCnt[q]++;

			// 경로 저장
			road.get(p)
				.add(new int[] { q, r });

		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int[] next : road.get(now)) {

				// 길 카운트 감수
				roadCnt[next[0]]--;

				// 기존보다 더 많은 포인트를 주는 경로를 찾으면 최대값 갱신
				if (point[next[0]] < point[now] + next[1]) {
					point[next[0]]  = point[now] + next[1];
					parent[next[0]] = now;
				}

				// 1빼고 조건에 맞으면 방문
				if (roadCnt[next[0]] == 0 && next[0] != 1) {
					q.add(next[0]);
				}
			}
		}
		System.out.println(point[1]);
		System.out.print("1 ");
		print(1, parent);

	}

	public static void print(int now, int[] arr) {
		if (arr[now] != 1) {
			print(arr[now], arr);
		}
		System.out.print(now + " ");
	}

}
