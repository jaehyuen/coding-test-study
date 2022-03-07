package baekjoon.구현.단어_뒤집기_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력받은 문자열 배열로 변환
		char[] strArr = br.readLine().toCharArray();

		// 태그 상태 여부 플래그
		boolean tagFlag = false;

		Stack<Character> s = new Stack<>();

		// 배열 순회
		for (int i = 0; i < strArr.length; i++) {

			// 태그가 끝나면 정상적으로 순방향 출력
			if (tagFlag && strArr[i] == '>') {

				for (char c : s) {
					System.out.print(c);
				}

				System.out.print(strArr[i]);
				s.clear();

				// 태그 플래그 변경
				tagFlag = false;

			} // 태그 출력끝나고 태그 시작이거나 문자열 시작일떄
			else if (!tagFlag && (strArr[i] == '<' || strArr[i] == ' ')) {

				// 테그 시작시 플래그 변경
				if (strArr[i] == '<') {
					tagFlag = true;
				}

				// 문자열 역방향 출력
				while (!s.isEmpty()) {
					System.out.print(s.pop());
				}
				System.out.print(strArr[i]);

			} else {
				s.push(strArr[i]);
			}

		}

		// 배열 순회 끝나고 스택에 값이 남았을때 역방향 출력
		while (!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}

}
