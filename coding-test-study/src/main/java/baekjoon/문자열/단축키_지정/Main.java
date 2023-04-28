package baekjoon.문자열.단축키_지정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashSet<Character> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {

			String input = br.readLine();
			String[] strArr = input.split(" ");
			String result = "";

			boolean flag = false;

			for (String s : strArr) {
				char tmp = s.charAt(0);

				if (tmp == ' ') {
					continue;
				}

				// 단축키 지정이 안됫을때
				if (!flag && !set.contains(Character.toLowerCase(tmp))) {

					// 단축키 지정 현황 셋에 등록
					set.add(Character.toLowerCase(tmp));

					// 커멘드 설정

					result += "[" + tmp + "]" + s.substring(1) + " ";

					// 플래그 설정
					flag = true;

				} else {
					result += s + " ";
				}
			}

			// 지정했으면 넘어감
			if (flag) {
				sb.append(result + "\n");
				continue;
			}

			char[] cArr = input.toCharArray();

			// 문장을 순회
			for (char tmp : cArr) {
				// 공백은 넘어감
				if (tmp == ' ') {
					continue;
				}
				// 단축키 지정이 안됫을때
				if (!set.contains(Character.toLowerCase(tmp))) {

					// 단축키 지정 현황 셋에 등록
					set.add(Character.toLowerCase(tmp));

					// 커멘드 설정
					input = input.replaceFirst(Character.toString(tmp), "[" + tmp + "]");

					// 플래그 설정
					flag = true;
					break;
				}
			}

			// 옵션 출력
			sb.append(input + "\n");
		}
		System.out.println(sb.toString());

	}
}
