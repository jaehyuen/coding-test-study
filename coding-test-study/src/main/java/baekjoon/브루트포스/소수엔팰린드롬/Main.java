package baekjoon.브루트포스.소수엔팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());

		boolean[]      arr = new boolean[1000001 * 2];
		arr[0] = true;
		arr[1] = true;

		// 에라토스테네스의 체 공식으로 소수 판별
		for (int i = 2; i * i <= 1000000 * 2; i++) {
			if (!arr[i]) {
				for (int j = i * i; j <= 1000000 * 2; j += i) {
					arr[j] = true;
				}
			}

		}

		// 숫자 찾기
		for (int i = N; i <= 1000000 * 2; i++) {
			String str = String.valueOf(i);

			// 소수일떄
			if (!arr[i]) {
				boolean flag = true;

				// 팰린드롭 검증
				for (int j = 0; j < str.length() / 2; j++) {
					if (str.charAt(j) != str.charAt(str.length() - 1 - j)) {
						flag = false;
						break;
					}
				}

				if (flag) {
					System.out.println(i);
					return;
				}
			}

		}

	}
}