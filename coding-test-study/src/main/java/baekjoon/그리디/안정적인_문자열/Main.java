package baekjoon.그리디.안정적인_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb  = new StringBuilder();

		int            num = 0;
		while (true) {
			char[] arr = br.readLine()
				.toCharArray();

			// 하이픈이 나오면 반복 종료
			if (arr[0] == '-') {
				break;
			}

			num++;

			Stack<Character> s = new Stack<Character>();

			for (int i = 0; i < arr.length; i++) {

				// 현재 { 나 스택이 비엿으면 스텍에 추가
				if (arr[i] == '{' || s.isEmpty()) {
					s.push(arr[i]);
				} else {

					// 지금 스택의 탑이 { 이면 안정적이기 떄문에 삭제, 아니면 스텍에 추가
					char now = s.peek();
					if (now == '{') {
						s.pop();
					} else {
						s.push(arr[i]);
					}
				}
			}

			int cnt       = 0;
			int stackSize = s.size();

			// 안정적이지 못한 문자열을 바꿔준다, 2개씩 짝을 맞추기 떄문에 포문은 2씩 증가한다
			for (int i = 0; i < stackSize; i += 2) {
				char now  = s.pop();
				char next = s.pop();

				// 반대로 되있으면 변경
				if (now == '{') {
					cnt++;
				}

				// 반대로 되있으면 변경
				if (next == '}') {
					cnt++;
				}

			}
			sb.append(num + ". " + cnt + "\n");
		}

		System.out.println(sb.toString());
	}

}
