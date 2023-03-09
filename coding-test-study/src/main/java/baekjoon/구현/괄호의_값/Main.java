package baekjoon.구현.괄호의_값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		// 스텍 선언
		Stack<Bracket> s = new Stack<Bracket>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		int prevIdx = Integer.MAX_VALUE;
		int sum = 0;
		int minIdx = Integer.MAX_VALUE;
		int result = 0;

		for (char c : arr) {

			if (s.empty()) {
				// 스택이 비었으면 넣어줌
				s.push(new Bracket(c, 0));
			} else if (c == '[' || c == '(') {

				Bracket prev = s.peek();

				// 괄호의 시작이면 넣어준다
				s.push(new Bracket(c, prev.idx + 1));
			} else {

				Bracket now = s.peek();

				// 괄호의 끝이면 닫는게 맞는지 체크
				if ((now.c == '[' && c == ']') || (now.c == '(' && c == ')')) {

					s.pop();
					int num = c == ']' ? 3 : 2;

					if (prevIdx == Integer.MAX_VALUE) {
						// 첫 타자이면
						sum = num;

					} else if (prevIdx < now.idx) {

						// 이전 뎁스보다 현제 뎁스가 크면 더하기 리스트에 저장해두고 곱샘부터 한다
						list.add(sum);
						sum = num;

					} else if (prevIdx > now.idx) {
						// 이전 뎁스가 현재 뎁스보다 크면

						// 그줌에서 최소 뎁스가 현재 뎁스보다 크면
						if (minIdx > now.idx) {

							list.add(sum);
							sum = 0;

							// 저장했던 더하기들 실행
							for (int i : list) {
								sum += i;
							}
							list.clear();

						}
						sum *= num;

					} else if (prevIdx == now.idx) {
						// 이전 뎁스와 현재 뎁스가 같으면 더해줌
						sum += num;
					}

					// 이전 뎁스 갱신
					prevIdx = now.idx;

					// 최소 뎁스 갱신
					minIdx = Math.min(now.idx, minIdx);

					// 시작 뎁스에 도착하면 변수 초기화
					if (now.idx == 0) {
						result += sum;
						prevIdx = Integer.MAX_VALUE;
						sum = 0;
						minIdx = Integer.MAX_VALUE;

					}
				}

				else {
					// 파싱 오류시 0출력
					System.out.println(0);
					return;
				}

			}

		}

		if (!s.empty()) {
			// 스택이 남아있으면 올바르지 않는 입력으로 0 출력
			System.out.println(0);
		} else {
			// System.out.println("Success" + result);
			System.out.println(result);

		}
	}
}

class Bracket {
	char c;
	int idx;

	Bracket(char c, int idx) {
		this.c = c;
		this.idx = idx;
	}
}