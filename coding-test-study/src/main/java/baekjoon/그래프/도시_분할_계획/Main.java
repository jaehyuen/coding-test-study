package baekjoon.그래프.도시_분할_계획;

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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<House>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<House>());
		}

		// 경로 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int tmp3 = Integer.parseInt(st.nextToken());

			list.get(tmp1).add(new House(tmp2, tmp3));
			list.get(tmp2).add(new House(tmp1, tmp3));
		}

		PriorityQueue<House> q = new PriorityQueue<>((o1, o2) -> {
			return o1.dis - o2.dis;
		});

		q.add(new House(1, 0));

		// 방문 체크 배열
		boolean[] v = new boolean[N + 1];

		int cnt = 0;
		int result = 0;
		int max = 0;

		while (!q.isEmpty()) {
			House now = q.poll();

			// 방문했으면 무시
			if (v[now.node]) {
				continue;
			}

			cnt++;
			result += now.dis;
			v[now.node] = true;
			max = Math.max(max, now.dis);

			// System.out.println(now);
			if (cnt == N) {
				break;
			}

			for (House next : list.get(now.node)) {
				q.add(next);
			}

		}

		// 유지비 총합에서 제일큰거를 다른 마을로 분리?
		System.out.println(result - max);

	}

}

class House {
	int node;
	int dis;

	@Override
	public String toString() {
		return "House [node=" + node + ", dis=" + dis + "]";
	}

	public House(int node, int dis) {

		this.node = node;
		this.dis = dis;
	}
}
