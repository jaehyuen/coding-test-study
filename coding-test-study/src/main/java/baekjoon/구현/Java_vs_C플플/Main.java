package baekjoon.구현.Java_vs_C플플;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();

		// c++ 형식의 가능성이 존재
		if (str.contains("_")) {

			char[] arr = str.toCharArray();

			// 에러(언더바로 시작)
			if (arr[0] == '_' || arr[str.length() - 1] == '_') {
				System.out.println("Error!");
				return;
			}

			for (int i = 0; i < arr.length; i++) {

				// 에러(대문자 언더바 혼용)
				if (arr[i] < 91) {
					System.out.println("Error!");
					return;
				}

				// 에러(언더바 중복 사용)
				if (i != 0 && arr[i - 1] == '_' && arr[i] == '_') {
					System.out.println("Error!");
					return;
				}
			}
			boolean flag = false;
			for (char c : arr) {

				// 언더바가 있엇으면 대문자로 번경
				if (flag) {
					flag = false;
					sb.append((char) (c - 32));

				} else if (c == '_') {
					// 언더바가 있으면 플래그 변경
					flag = true;
				} else {
					sb.append(c);
				}
			}

		} else {
			// 자바 형식의 가능성이 존재
			char[] arr = str.toCharArray();

			// 에러 (대문자로 시작)
			if (arr[0] < 'a') {
				System.out.println("Error!");
				return;
			}

			for (char c : arr) {

				// 대문자이면 언더바를 추가
				if (c < 'a') {
					sb.append("_");
					sb.append((char) (c + 32));

				} else {
					sb.append(c);
				}
			}

		}

		System.out.println(sb.toString());
	}

}
