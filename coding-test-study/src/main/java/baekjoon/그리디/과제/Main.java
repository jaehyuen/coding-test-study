package baekjoon.그리디.과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader         br         = new BufferedReader(new InputStreamReader(System.in));
		int                    N          = Integer.parseInt(br.readLine());

		PriorityQueue<int[]>   assignment = new PriorityQueue<int[]>((o1, o2) -> {
												if (o1[0] == o2[0]) {
													return o2[1] - o1[1];
												}
												return o2[0] - o1[0];
											});
		PriorityQueue<Integer> q          = new PriorityQueue<Integer>((o1, o2) -> {

												return o2 - o1;
											});

		// 에러 처리용 초기값
		assignment.add(new int[] { 0, 0 });

		// 마지막 과제하는 날 변수
		int start = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int             d  = Integer.parseInt(st.nextToken());
			int             w  = Integer.parseInt(st.nextToken());

			// 마지막 과제하는 날
			start = Math.max(start, d);

			assignment.add(new int[] { d, w });

		}

		int total = 0;

		// 역으로 계산한다

		for (int i = start; i > 0; i--) {

			// 과제가 남아있다면
			if (!assignment.isEmpty()) {

				// 오늘 + i 까지 끝내야하는 과제를 큐에 넣어줌
				while (assignment.peek()[0] >= i) {
					q.add(assignment.poll()[1]);
				}
			}

			// 진행할수 있는 과제가 있다면
			if (!q.isEmpty()) {
				total += q.poll();
			}

		}

		System.out.println(total);

	}
}
