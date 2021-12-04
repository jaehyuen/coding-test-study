package baekjoon.그래프.다익스트라.지름길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		ArrayList<ArrayList<Road>> list = new ArrayList<>();

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= D; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int tmp3 = Integer.parseInt(st.nextToken());

			if (tmp2 > D || tmp3 > D)
				continue;

			list.get(tmp1).add(new Road(tmp2, tmp3));
		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		int[] arr = new int[D + 1];

		while (!q.isEmpty()) {
			int now = q.poll();

			for (Road road : list.get(now)) {

				if (road.des > D)
					continue;

				if (arr[road.des] == 0 || arr[road.des] > arr[now] + road.km) {
					q.add(road.des);
					arr[road.des] = arr[now] + road.km;
				}

			}

			int next = now + 1;

			if (next > D)
				continue;

			if (arr[next] == 0 || arr[next] > arr[now] + 1) {
				q.add(next);
				arr[next] = arr[now] + 1;
			}
		}

		System.out.println(arr[D]);

	}
}

class Road {
	int des;
	int km;

	Road(int des, int km) {
		this.des = des;
		this.km = km;
	}
}
