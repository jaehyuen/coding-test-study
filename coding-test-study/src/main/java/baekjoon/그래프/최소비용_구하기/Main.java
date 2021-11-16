package baekjoon.그래프.최소비용_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader            br   = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer           st;

		int                       N    = Integer.parseInt(br.readLine());
		int                       M    = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Bus>> list = new ArrayList<ArrayList<Bus>>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Bus>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int now  = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int fee  = Integer.parseInt(st.nextToken());
			list.get(now)
				.add(new Bus(next, fee));
		}

		st = new StringTokenizer(br.readLine());

		int                start  = Integer.parseInt(st.nextToken());
		int                finish = Integer.parseInt(st.nextToken());

		PriorityQueue<Bus> q      = new PriorityQueue<Bus>((o1, o2) -> {
										return o1.fee - o2.fee;
									});
		int                INF    = Integer.MAX_VALUE;
		Bus[]              arr    = new Bus[N + 1];
//		boolean[]          v      = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {

			if (i == start) {
				arr[i] = new Bus(i, 0);
			} else {
				arr[i] = new Bus(i, INF);
			}

			q.add(arr[i]);
		}

		while (!q.isEmpty()) {
			Bus b = q.poll();

			if (b.fee == Integer.MAX_VALUE)
				continue;

			for (Bus nextBus : list.get(b.next)) {

				if (arr[nextBus.next].fee > arr[b.next].fee + nextBus.fee) {
					arr[nextBus.next].fee = arr[b.next].fee + nextBus.fee;

					q.remove(arr[nextBus.next]);
					q.add(arr[nextBus.next]);
				}
			}

		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(arr[finish].fee);

	}

}

class Bus {
	int next, fee;

	public Bus(int next, int fee) {
		this.next = next;
		this.fee  = fee;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + next + " " + fee + "]";
	}
}
