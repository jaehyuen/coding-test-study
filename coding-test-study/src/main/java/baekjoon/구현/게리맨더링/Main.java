package baekjoon.구현.게리맨더링;

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
	public static int                           N;
	public static LinkedList<Integer>           combi = new LinkedList<Integer>();
	public static ArrayList<ArrayList<Integer>> list  = new ArrayList<ArrayList<Integer>>();;
	public static int                           min   = Integer.MAX_VALUE;
	public static int[]                         population;
	public static int                           total = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N          = Integer.parseInt(br.readLine());

		population = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		list.add(new ArrayList<Integer>());

		// 인구 입력
		for (int i = 1; i <= N; i++) {
			population[i]  = Integer.parseInt(st.nextToken());
			total         += population[i];
			list.add(new ArrayList<Integer>());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp = Integer.parseInt(st.nextToken());

			for (int j = 0; j < tmp; j++) {

				int b = Integer.parseInt(st.nextToken());

				// 연결
				list.get(i)
					.add(b);
				list.get(b)
					.add(i);

			}
		}

		find(1, 1);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	public static void find(int idx, int start) {

		// 구역을 조합후 가능한 구역인지 체크
		min = Math.min(min, check());

		if (idx == N) {
			return;
		}

		for (int i = start; i <= N; i++) {

			combi.add(i);
			find(idx++, i + 1);
			combi.removeLast();
		}

	}

	public static int check() {
		int[] v   = new int[N + 1];
		int   sum = 0;

		for (int i : combi) {
			// 구역 나눈다 -1, 0 으로
			v[i]  = -1;
			sum  += population[i];
		}

		int cnt = 0;

		for (int i = 1; i <= N; i++) {

			// 방문 안햇으면 체크
			if (v[i] < 1) {
				cnt++;
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(i);

				// 현재 구역 저장
				int flag = v[i];

				// 방문 처리
				v[i] = 1;

				while (!q.isEmpty()) {
					int now = q.poll();

					for (int next : list.get(now)) {

						// 같은 구역이면 탐색
						if (v[next] == flag) {
							q.add(next);
							v[next] = 1;

						}
					}
				}

			}
		}

		// 2군데로 나눠졋으면 인구수 비교진행
		if (cnt == 2) {
			return Math.abs(total - sum - sum);
		} else {
			return Integer.MAX_VALUE;
		}

	}
}
