package baekjoon.문자열.PPAP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();

		Stack<Character> s = new Stack<>();

		for (int i = 0; i < str.length; i++) {
			s.push(str[i]);
			if (s.size() >= 4) {

				// 스택의 크기가 4이상이면 ppap체크
				char[] tmp = new char[4];

				for (int j = 3; j >= 0; j--) {
					tmp[j] = s.pop();
				}

				// ppap 문자열을 찾으면 p로 변경
				if (tmp[0] == 'P' && tmp[1] == 'P' && tmp[2] == 'A' && tmp[3] == 'P') {
					s.push('P');
				} else {

					// ppap가 아니면 빼놧던 문자를 다시 넣어줌
					for (int j = 0; j < 4; j++) {
						s.push(tmp[j]);
					}
				}

			}

		}
		if (s.empty()) {
			// 스택이 비엇으면 ppap
			System.out.println("PPAP");
		} else if (s.size() == 1 && s.peek() == 'P') {
			// 스택에 p하나만 남으면 ppap
			System.out.println("PPAP");
		} else {
			// 나머지는 np
			System.out.println("NP");
		}

	}

}
