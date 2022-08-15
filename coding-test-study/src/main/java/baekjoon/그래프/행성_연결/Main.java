package baekjoon.그래프.행성_연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 비용 저장용 리스트
		ArrayList<ArrayList<Planet>> list = new ArrayList<>();
		list.add(new ArrayList<>());

		// 비용 관련 그래프 생성
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Planet> tmp = new ArrayList<>();

			for (int j = 0; j < N; j++) {
				int cost = Integer.parseInt(st.nextToken());

				if (j == i)
					continue;

				tmp.add(new Planet(j + 1, cost));
			}
			list.add(tmp);

		}

		long result = 0;
		int cnt = 0;
		PriorityQueue<Planet> q = new PriorityQueue<>((o1, o2) -> {
			return o1.cost - o2.cost;
		});

		boolean[] v = new boolean[N + 1];

		// 1번 행성부터 시작
		q.add(new Planet(1, 0));

		while (!q.isEmpty()) {
			Planet now = q.poll();

			// 방문 했으면 다음거 탐색
			if (v[now.next]) {
				continue;
			}

			cnt++;
			result += now.cost;
			v[now.next] = true;

			// 전부 탐색했을떄
			if (cnt == N) {
				break;
			}

			for (Planet next : list.get(now.next)) {
				q.add(next);
			}

		}

		System.out.println(result);
	}

}

class Planet {
	int next;
	int cost;

	public Planet(int next, int cost) {
		this.next = next;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Planet [next=" + next + ", cost=" + cost + "]";
	}

}
