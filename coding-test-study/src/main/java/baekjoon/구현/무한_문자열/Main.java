package baekjoon.구현.무한_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
		String         str1 = br.readLine();
		String         str2 = br.readLine();

		int            len1 = str1.length();
		int            len2 = str2.length();

		// 길이가 같으면 동일한지 비교
		if (len1 == len2) {
			if (str1.equals(str2)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			return;
		}

		int           lcm = lcm(len1, len2);

		StringBuilder sb1 = new StringBuilder(str1);
		StringBuilder sb2 = new StringBuilder(str2);

		// 최소공배수 많큼 이어 붙인다
		for (int i = 0; i < lcm / len1 - 1; ++i) {
			sb1.append(str1);
		}

		for (int i = 0; i < lcm / len2 - 1; ++i) {
			sb2.append(str2);
		}

		// 비교
		if (sb1.toString()
			.equals(sb2.toString())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}

	public static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
}
