package baekjoon.자료구조.스택_수열;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner        s     = new Scanner(System.in);
		int            T     = s.nextInt();
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < T; i++) {
			int tmp = s.nextInt();

			if (tmp == 0) {
				stack.pop();
			} else {
				stack.push(tmp);
			}
		}

		int result = 0;
		for (int i : stack) {
			result += i;
		}
		System.out.println(result);

	}

}
