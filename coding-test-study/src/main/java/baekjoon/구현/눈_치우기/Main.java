package baekjoon.구현.눈_치우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader         br = new BufferedReader(new InputStreamReader(System.in));

		int                    N  = Integer.parseInt(br.readLine());
		StringTokenizer        st = new StringTokenizer(br.readLine());

		// 큰값부터 뽑아주는 우선순위큐 생성
		PriorityQueue<Integer> q  = new PriorityQueue<Integer>((o1, o2) -> {
										return o2 - o1;
									});

		// 큐에 값을 넣는다
		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}

		int cnt = 0;

		// 눈을 다 치울때까지 반복
		while (!q.isEmpty()) {

			// 눈이 가장 많이 쌓인 집 가져오기
			int first = q.poll();

			// 집이 더 남으면?
			if (!q.isEmpty()) {

				// 눈이 두번쨰로 많이 쌓인 집 가져오기
				int second = q.poll();

				// 둘이 한번에 치운다
				first -= second;
				cnt   += second;

				// 다 치워지지 않았으면 큐에 넣는다
				if (first > 0) {
					q.add(first);
				}

			} else {
				// 한번에 다 치워버림
				cnt += first;
			}

		}
		System.out.println(cnt > 1440 ? -1 : cnt);

	}
}
