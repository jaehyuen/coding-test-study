package baekjoon.구현.행운의_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// 입력 문자열 배열
	public static int[] str = new int[26];

	// 문자열 재배치 배열
	public static char[] arr = new char[10];

	public static int N = 0;

	public static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (char c : br.readLine().toCharArray()) {
			str[c - 'a']++;
			N++;
		}
		System.out.println(Arrays.toString(str));

		find(0);
		System.out.println(cnt);
	}

	public static void find(int idx) {

		// 행운의 문자열 만들어지면 카운트 중가
		if (idx == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < str.length; i++) {

			if (str[i] > 0) {

				// 뒤랑 같으면 넘어감
				if (idx > 0 && arr[idx - 1] == (char) ('a' + i)) {
					continue;
				}

				str[i]--;
				arr[idx] = (char) ('a' + i);
				find(idx + 1);
				str[i]++;
			}

		}

	}
}
