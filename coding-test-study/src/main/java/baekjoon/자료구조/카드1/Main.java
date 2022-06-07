package baekjoon.자료구조.카드1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int            N  = Integer.parseInt(br.readLine());

		Queue<Integer> q  = new LinkedList<Integer>();

		// 큐에 값을 채운다
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		// 한개 남을때까지 반복
		while (q.size() > 1) {
			System.out.print(q.poll() + " ");

			q.add(q.poll());
		}
		System.out.println(q.poll());

	}

}
