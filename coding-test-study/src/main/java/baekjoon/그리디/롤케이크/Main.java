package baekjoon.그리디.롤케이크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 우선 순위 큐 선언
		// 10의 배수, 숫자가 낮은 순으로 우선순위 부여
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((o1, o2) -> {
			if ((o1 % 10) == (o2 % 10)) {
				return o1 - o2;
			}
			return (o1 % 10) - (o2 % 10);
		});

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}

		int result = 0;
		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == 10) {
				// 롤 길이가 10이면 먹는다
				result++;
			} else if (now > 10) {
				// 롤 길이가 10보다 크면 자르고 10 만큼 먹는다
				result++;
				if (now - 10 == 10) {

					// 자른 이후에도 10이 남으면 먹는다
					result++;
				} else {
					// 자르고 남은 자투리를 큐에 넣는다
					q.add(now - 10);
				}

				M--;
			}
			if (M == 0) {
				break;
			}
		}

		System.out.println(result);
	}

}
