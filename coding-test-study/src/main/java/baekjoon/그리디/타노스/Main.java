package baekjoon.그리디.타노스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();

		int cnt1 = 0;
		int cnt2 = 0;

		// 1, 0 갯수 구하기
		for (char c : str) {
			if (c == '1') {
				cnt1++;
			} else {
				cnt2++;
			}
		}

		// 줄이기
		cnt1 /= 2;
		cnt2 /= 2;

		// 1은 오른쪽 0은 왼쪽부터 지운다
		for (int i = 0; i < str.length; i++) {
			if (cnt1 == 0) {
				break;
			}

			if (str[i] == '1') {
				str[i] = 'a';
				cnt1--;
			}
		}

		for (int i = str.length - 1; i >= 0; i--) {
			if (cnt2 == 0) {
				break;
			}

			if (str[i] == '0') {
				str[i] = 'a';
				cnt2--;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (char c : str) {
			if (c != 'a') {
				sb.append(c);
			}
		}
		System.out.println(sb);

	}

}
