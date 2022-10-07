package baekjoon.문자열.놀라운_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();

			// 종료
			if (str.equals("*")) {
				return;
			}

			char[]  arr  = str.toCharArray();
			boolean flag = false;

			for (int i = 0; i < arr.length - 1; i++) {

				// 중복 여부를 체크하기 위한 셋
				HashSet<String> set = new HashSet<String>();
				int             cnt = 0;

				for (int j = 0; j < arr.length - i - 1; j++) {
					cnt++;
					set.add(arr[j] + "" + arr[j + 1 + i]);

					// 카운트가 다르면 중복이다
					if (cnt != set.size()) {
						flag = true;
						break;
					}
				}

				if (flag) {
					break;
				}

			}
			if (flag) {
				System.out.println(str + " is NOT surprising.");
			} else {
				System.out.println(str + " is surprising.");

			}

		}

	}
}
