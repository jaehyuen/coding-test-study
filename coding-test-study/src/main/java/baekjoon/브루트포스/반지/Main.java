package baekjoon.브루트포스.반지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str2 = br.readLine();

			if (str2.contains(str1)) {
				cnt++;

			} else {

				// 기준 문자열 크기만큼 순서를 바꾼다
				for (int j = 0; j < str1.length(); j++) {

					str2 = str2.substring(1) + str2.substring(0, 1);

					if (str2.contains(str1)) {
						cnt++;
						break;

					}

				}

			}

		}
		System.out.println(cnt);

	}

}