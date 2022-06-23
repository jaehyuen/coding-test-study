package baekjoon.자료구조.좋은_단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());
		int            cnt = 0;

		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine()
				.toCharArray();

			// 홀수이면 좋은 단어가 아니다
			if (arr.length % 2 == 0) {

				Stack<Character> s = new Stack<Character>();

				// 쓰레기값 추가
				s.push('X');

				for (int j = 0; j < arr.length; j++) {
					char now = s.peek();

					if (now == arr[j]) {
						s.pop();
					} else {
						s.push(arr[j]);
					}
				}

				// 스택 사이즈가 1이면 좋은단어
				if (s.size() == 1) {
					cnt++;
				}
			}

		}

		System.out.println(cnt);

	}

}
