package baekjoon.구현.단어_맞추기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            T  = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			char[] str  = br.readLine()
				.toCharArray();

			int    idx1 = -1;
			int    idx2 = 0;
			char   tmp;

			// 값이 작아지는 부분을 찾는다
			for (int j = str.length - 1; j > 0; j--) {
				if (str[j - 1] < str[j]) {
					idx1 = j - 1;
					break;
				}
			}

			// 안작아지면 마지막 이라는 뜻
			if (idx1 == -1) {
				System.out.println(new String(str));
			} else {
				for (int j = str.length - 1; j >= 0; j--) {
					if (str[idx1] < str[j]) {
						idx2 = j;
						break;
					}
				}
				tmp       = str[idx1];
				str[idx1] = str[idx2];
				str[idx2] = tmp;

				Arrays.sort(str, idx1 + 1, str.length);

				System.out.println(new String(str));
			}

		}
	}

}
