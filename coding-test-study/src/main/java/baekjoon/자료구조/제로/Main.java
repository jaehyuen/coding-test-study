package baekjoon.자료구조.제로;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner       s   = new Scanner(System.in);
		int           T   = s.nextInt();
		int[]         arr = new int[T];

		StringBuilder sb  = new StringBuilder();

		for (int i = 0; i < T; i++) {
			arr[i] = s.nextInt();

		}

		Stack<Integer> stack = new Stack<Integer>();
		int            tmp   = 1;
		for (int i = 0; i < T; i++) {

			for (int j = tmp; j <= arr[i]; j++) {

				sb.append("+\n");
				stack.add(j);
				tmp = j + 1;
			}

			if (!stack.isEmpty() && stack.peek() == arr[i]) {
				// System.out.println("-");
				sb.append("-\n");
				stack.pop();
			} else {
				System.out.println("NO");
				return;
			}

		}

		System.out.println((sb.toString()));

	}

}
