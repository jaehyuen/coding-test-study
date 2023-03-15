package baekjoon.구현.삼의_배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		if (str.length() == 1) {
			// 한자리수는 바로 계산
			System.out.println(0);
			if (Integer.parseInt(str) % 3 == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} else {
			int cnt = 0;

			while (true) {
				cnt++;

				// 숫자를 배열로 변경
				char[] arr = str.toCharArray();

				int tmp = 0;

				// 모든 자리수 더하기
				for (char c : arr) {
					tmp += c - '0';
				}

				// 10 이하이면 출력후 종료
				if (tmp < 10) {
					System.out.println(cnt);
					if (tmp % 3 == 0) {
						System.out.println("YES");
					} else {
						System.out.println("NO");
					}
					break;
				} else {
					str = Integer.toString(tmp);
				}
			}
		}
	}
}
