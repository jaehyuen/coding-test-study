package baekjoon.문자열.동일한_단어_그룹화하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			// 문자열을 char 배열로 변경
			char[] tmp = br.readLine().toCharArray();

			// 정렬
			Arrays.sort(tmp);

			// 셋에 추가
			set.add(new String(tmp));
		}

		System.out.println(set.size());

	}

}
