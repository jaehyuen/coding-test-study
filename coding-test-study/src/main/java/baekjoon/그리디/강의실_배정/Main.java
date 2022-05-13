package baekjoon.그리디.강의실_배정;

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
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			list.add(new int[] { S, T });

		}

		// 시작 순으로 정렬
		Collections.sort(list, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(list.get(0)[1]);
		for (int i = 1; i < N; i++) {
			// 끝나는 시간이 다음번 시작시간 보다 작으면 큐에서 빼버림
			if (q.peek() <= list.get(i)[0]) {
				q.poll();
			}
			q.offer(list.get(i)[1]);
		}
		System.out.println(q.size());
	}

}
