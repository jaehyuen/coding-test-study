package baekjoon.정렬.접미사_배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int length = str.length();
		String[] arr = new String[length];

		// 입력받은 문자열을 하나씩 때서 배열에 넣는
		for (int i = 0; i < length; i++) {
			arr[i] = str;

			str = str.substring(1, str.length());

		}

		//버블 정렬로 접미사를 정렬한다
		for (int i = length - 1; i > 0; i--) {
			for (int j = 1; j < length; j++) {
				if (arr[j - 1].compareTo(arr[j]) > 0) {
					String tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}

			}
		}

		for (String s : arr) {
			System.out.println(s);
		}

	}

}
