package baekjoon.문자열.괄호_끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		Stack<Character> s = new Stack<>();

		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			if (s.isEmpty()) {
				// 스택이 비엇을때
				if (arr[i] == ')') {
					// 닫는 괄호가 나오면 카운트 증가
					cnt++;
				} else {
					// 여는 괄호가 나오면 스택에 넣어줌
					s.push(arr[i]);
				}
			} else {
				// 스택이 비어있지 않을떄

				if (arr[i] == ')') {
					// 닫는 괄호가 나왔때
					if (s.peek() == '(') {
						// 스택의 탑 부분이 여는 괄호면 빼줌
						s.pop();
					} else {

						// 스택의 탑부분이 닫는 괄호이면 카운트 증가
						cnt++;
					}
				} else {

					// 여는 괄호면 스택에 넣어줌
					s.push(arr[i]);
				}

			}

		}
		// 카운트와 남은 스택의 사이즈를 더해서 출력
		System.out.println(cnt + s.size());
	}
}