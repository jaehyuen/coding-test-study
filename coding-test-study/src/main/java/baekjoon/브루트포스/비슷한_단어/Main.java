package baekjoon.브루트포스.비슷한_단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());

		String[]       arr = new String[N];

		// 문자열 저장
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		int cnt = 0;

		// 모든 경우의수 판단
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				cnt += find(arr[i], arr[j]);
			}
		}

		System.out.println(cnt);

	}

	public static int find(String a, String b) {

		// 소문자들을 대문자 A부터 순서대로 변경
		char start = 'A';

		for (int i = 0; i < a.length(); i++) {
			char idx = a.charAt(i);

			// 현재 위치의 값이 소문자면
			if (Character.isLowerCase(idx)) {

				// 문자를 동일하게 변경
				a = a.replaceAll(Character.toString(idx), Character.toString(start));
				b = b.replaceAll(Character.toString(b.charAt(i)), Character.toString(start));

				start++;
			}

		}

		// 만들어진 문자열이 같으면 비슷한 단어
		if (a.equals(b)) {
			return 1;
		} else {
			return 0;
		}

	}
}