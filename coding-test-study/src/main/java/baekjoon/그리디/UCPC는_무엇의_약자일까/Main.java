package baekjoon.그리디.UCPC는_무엇의_약자일까;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br      = new BufferedReader(new InputStreamReader(System.in));
		char[]         fullStr = br.readLine()
			.toCharArray();
		char[]         str     = { 'U', 'C', 'P', 'C' };
		int            idx     = 0;
		for (char c : fullStr) {
			if (c == str[idx]) {
				idx++;
			}

			if (idx == 4) {
				break;
			}
		}

		if (idx == 4) {
			System.out.println("I love UCPC");
		} else {
			System.out.println("I hate UCPC");
		}

	}

}
