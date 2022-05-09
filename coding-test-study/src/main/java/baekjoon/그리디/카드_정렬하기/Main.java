package baekjoon.그리디.카드_정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 우선순위 큐에 카드 묶음을 넣어준다
		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}

		int result = 0;
		// 큐가 비워질때까지 작은 묶음 2개씩 합쳐준다
		while (!q.isEmpty()) {
			if (q.size() > 1) {
				int a = q.poll();
				int b = q.poll();

				result += a + b;
				q.add(a + b);
			} else {
				q.poll();
			}

		}

		System.out.println(result);

	}

}
