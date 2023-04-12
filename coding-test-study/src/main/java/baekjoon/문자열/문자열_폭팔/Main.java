package baekjoon.문자열.문자열_폭팔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();

		Stack<Character> stack = new Stack<>();
		Stack<Integer> idxStack = new Stack<>();

		for (int i = 0; i < str.length; i++) {
			stack.push(str[i]);
			if (idxStack.empty()) {

				if (bomb[0] == str[i]) {
					// 시작이 같으면 1추가
					idxStack.push(1);
				} else {
					// 0추가
					idxStack.push(0);
				}

			} else {
				if (bomb[idxStack.peek()] == str[i]) {
					// 시작이 같으면 1추가
					idxStack.push(idxStack.peek() + 1);
				} else {
					if (bomb[0] == str[i]) {
						idxStack.push(1);
					} else {
						idxStack.push(0);
					}

				}
			}

			if (idxStack.peek() == bomb.length) {
				for (int j = 0; j < bomb.length; j++) {
					idxStack.pop();
					stack.pop();
				}
			}

		}

		if (stack.isEmpty()) {
			System.out.println("FRULA");

		} else {
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			System.out.println(sb.reverse());
		}

	}

}
