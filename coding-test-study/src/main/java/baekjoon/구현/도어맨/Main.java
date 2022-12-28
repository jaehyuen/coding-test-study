package baekjoon.구현.도어맨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader        br   = new BufferedReader(new InputStreamReader(System.in));
		int                   N    = Integer.parseInt(br.readLine());

		char[]                tmp  = br.readLine()
			.toCharArray();

		LinkedList<Character> list = new LinkedList<Character>();

		// 대기줄 입력
		for (char c : tmp) {
			list.add(c);
		}

		Stack<Character> s   = new Stack<Character>();
		int              cnt = 0;
		while (true) {

			// 줄이 없으면 반복 종료
			if (list.isEmpty()) {
				break;
			}
			// 비었으면 넣어줌
			if (s.empty()) {
				s.push(list.remove(0));
			} else {
				char first = list.remove(0);

				// 둘이 다르면 입장
				if (s.peek() != first) {
					s.pop();
				} else {
					// 무조건 첫번쨰 사람을 넣어야 할때
					if (list.isEmpty()) {
						// 기억력이 충분하면 넣어줌
						if (s.size() < N) {
							s.push(first);
						} else {
							// 기억력이 부족하면 종료
							break;
						}

					} else {
						char second = list.remove(0);

						// 둘이 다르면 입장
						if (s.peek() != second) {
							s.pop();
							list.add(0, first);
						} else {
							// 기억력이 충분하면 넣어줌
							if (s.size() < N) {
								s.push(first);
								list.add(0, second);
							} else {
								// 기억력이 부족하면 종료
								break;
							}
						}
					}

				}

			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
