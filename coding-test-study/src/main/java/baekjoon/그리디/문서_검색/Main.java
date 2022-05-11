package baekjoon.그리디.문서_검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String word = br.readLine();

		int cnt = 0;
		// 문서에 문자열이 있으면 반복
		while (str.contains(word)) {
			cnt++;

			// 해당 문자열을 느낌표로 치환해준다
			str = str.replaceFirst(word, "!");
		}
		System.out.println(cnt);

	}

}
