package baekjoon.자료구조.균형잡힌_세상;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		while (true) {
			stack.clear();
			String str = s.nextLine();
			String result = "yes";
			if (str.equals(".")) {
				break;
			}

			sb.append(test(str) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static String test(String str) {
		Stack<Character> stack = new Stack<>();

		for (char zz : str.toCharArray()) {

			if (zz == '(' || zz == '[') {
				stack.push(zz);

			} else if (zz == ']') {

				if (stack.isEmpty() || stack.peek() != '[') {
					return "no";
				} else {

					stack.pop();
				}
			} else if (zz == ')') {

				if (stack.isEmpty() || stack.peek() != '(') {
					return "no";
				} else {

					stack.pop();
				}
			}
		}

		return "yes";
	}

}
