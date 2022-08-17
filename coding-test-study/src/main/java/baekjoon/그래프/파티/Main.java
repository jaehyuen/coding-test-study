package baekjoon.그래프.파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader             br    = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer            st    = new StringTokenizer(br.readLine());

		int                        N     = Integer.parseInt(st.nextToken());
		int                        M     = Integer.parseInt(st.nextToken());
		int                        X     = Integer.parseInt(st.nextToken());

		// 순방향 그래프
		ArrayList<ArrayList<Town>> list1 = new ArrayList<ArrayList<Town>>();

		// 역방향 그래프
		ArrayList<ArrayList<Town>> list2 = new ArrayList<ArrayList<Town>>();

		for (int i = 0; i <= N; i++) {
			list1.add(new ArrayList<Town>());
			list2.add(new ArrayList<Town>());

		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			list1.get(from)
				.add(new Town(to, time));

			list2.get(to)
				.add(new Town(from, time));

		}

		// 다익스트라로 오고 가는 최소값을 구한다
		Town[] go   = find(N, X, list1);
		Town[] back = find(N, X, list2);

		int    max  = 0;

		for (int i = 1; i <= N; i++) {

			max = Math.max(max, go[i].time + back[i].time);
		}

		System.out.println(max);

	}

	public static Town[] find(int n, int x, ArrayList<ArrayList<Town>> list) {

		// 시간 저장 배열
		Town[] arr = new Town[n + 1];

		// 시작 위치는 0으로 초기
		for (int i = 1; i <= n; i++) {
			if (i == x) {
				arr[i] = new Town(i, 0);
			} else {
				arr[i] = new Town(i, Integer.MAX_VALUE);
			}
		}

		PriorityQueue<Town> q = new PriorityQueue<Town>((o1, o2) -> {
			return o1.time - o2.time;
		});

		// 시작위치 추가
		q.add(arr[x]);

		while (!q.isEmpty()) {
			Town now = q.poll();

			for (Town next : list.get(now.next)) {

				// 다른경로를 통해 돌아오는게 더 빠르면 큐에 추가
				if (arr[next.next].time > arr[now.next].time + next.time) {
					arr[next.next].time = arr[now.next].time + next.time;
					q.add(arr[next.next]);
				}

			}

		}
		return arr;
	}
}

class Town {
	int next;
	int time;

	public Town(int next, int time) {
		this.next = next;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Town [next=" + next + ", time=" + time + "]";
	}
}
