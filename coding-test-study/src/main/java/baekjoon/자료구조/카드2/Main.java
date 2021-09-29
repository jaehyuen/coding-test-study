package baekjoon.자료구조.카드2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner        s     = new Scanner(System.in);
		int            N     = s.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {

			queue.add(i);

		}

		while (queue.size() != 1) {
			queue.poll();
			queue.add(queue.poll());

		}

		System.out.println(queue.poll());
	}

}
