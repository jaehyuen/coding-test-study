package baekjoon.그리디.블로그2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
		int            N    = Integer.parseInt(br.readLine());
		char[]         str  = br.readLine()
			.toCharArray();

		int            cnt1 = 0;
		int            cnt2 = 0;

		for (int i = 1; i < str.length; i++) {

			// 문자열이 연속되지않으면 카운팅
			if (str[i - 1] != str[i]) {
				if (str[i - 1] == 'B') {
					cnt1++;
				} else {
					cnt2++;
				}
			}

		}
		if (str[str.length - 1] == 'B') {
			cnt1++;
		} else {
			cnt2++;
		}

		System.out.println(Math.min(cnt1, cnt2) + 1);
	}

}
