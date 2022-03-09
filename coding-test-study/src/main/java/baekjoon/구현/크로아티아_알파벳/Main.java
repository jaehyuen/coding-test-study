package baekjoon.구현.크로아티아_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[] test;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 변환된 알파벳 리스트
		String[] arr = new String[] { "dz=", "lj", "nj", "c=", "c-", "d-", "s=", "z=" };
		String str = br.readLine();

		// 결과값
		int result = 0;

		// 변경된 알파벳을 순회하며 카운팅
		for (String a : arr) {

			// 알파벳 앞에 특수문자(#)를 넣어주고 그를 기준으로 나눠 갯수를 파악한다
			str = str.replaceAll(a, "#" + a);
			result += str.split("#").length - 1;

			// 갯수를 카운팅후 다른 특수문자로(%) 변경
			str = str.replaceAll("#" + a, "%");
		}

		// 특수문자를 지워주고 나머지 알파벳 개수를 체크
		str = str.replaceAll("%", "");
		System.out.println(result + str.length());

	}
}
