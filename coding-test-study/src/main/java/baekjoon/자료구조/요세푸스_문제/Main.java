package baekjoon.자료구조.요세푸스_문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		int N = s.nextInt();
		int K = s.nextInt();

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		int tmp = 1;
		System.out.print("<");
		while (!queue.isEmpty()) {
			if (tmp > K) {
				tmp = 1;
			}

			if (tmp == K) {
				System.out.print(queue.poll());
				if(!queue.isEmpty()) {
					System.out.print(", ");
				}
			} else {
				queue.offer(queue.poll());
			}
			
			
			tmp++;
		}

		System.out.println(">");
	}

}
