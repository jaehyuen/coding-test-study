package baekjoon.문자열.화학식량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < str.length; i++) {

			if (s.empty()) {
				// 스텍이 비엇으면 바로 넣어줌
				s.push(getNum(str[i]));
			} else {
				int idx = Character.getNumericValue(str[i]);

				if (idx > 1 && idx < 10) {
					// 숫자면 이전값이랑 곱해줌
					s.push(s.pop() * idx);
				} else if (str[i] == '(') {
					// 괄호의 시작이면 스텍에 넣어줌
					s.push(-1);
				} else if (str[i] == ')') {
					// 괄호의 끝이면 괄호 계산
					int sum = 0;

					// 괄호가 나올때까지 값을 더해줌
					while (s.peek() != -1) {
						sum += s.pop();
					}
					s.pop();
					s.push(sum);
				} else {
					s.push(getNum(str[i]));
				}
			}
		}

		int sum = 0;
		// 스텍에 저장된 값을 다 더해줌
		while (!s.empty()) {
			sum += s.pop();
		}
		System.out.println(sum);

	}

	public static int getNum(char c) {
		if (c == 'H') {
			return 1;
		} else if (c == 'C') {
			return 12;
		} else if (c == 'O') {
			return 16;
		}

		return -1;
	}

}
