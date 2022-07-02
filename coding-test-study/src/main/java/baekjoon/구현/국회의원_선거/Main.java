package baekjoon.구현.국회의원_선거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dasom = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			return o2 - o1;
		});

		for (int i = 1; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			q.add(tmp);
		}

		// 후보자가 한명이면 다솜이 당선
		if (N == 1) {
			System.out.println(0);
		} else {
			int cnt = 0;

			// 후보자중 쵸가 많은사람이 있으면 매수를 진행
			while (q.peek() >= dasom) {
				dasom++;
				q.add(q.poll() - 1);
				cnt++;
			}

			System.out.println(cnt);

		}
	}
}
