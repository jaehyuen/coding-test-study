package baekjoon.브루트포스.단어_나누기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		ArrayList<String> list = new ArrayList<>();

		// 자를 위치를 찾는다
		for (int i = 1; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				String str1 = "";
				String str2 = "";
				String str3 = "";

				// 문자열을 3개로 나누고 역순으로 배치
				for (char c : str.substring(0, i).toCharArray()) {
					str1 = c + str1;
				}
				for (char c : str.substring(i, j).toCharArray()) {
					str2 = c + str2;
				}
				for (char c : str.substring(j).toCharArray()) {
					str3 = c + str3;
				}
				list.add(str1 + str2 + str3);

			}
		}
		// 정렬후 처음값 출력
		Collections.sort(list);
		System.out.println(list.get(0));

	}

}