package baekjoon.구현.피터팬_프레임;

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

		// 단어 배열
		char[] str = br.readLine().toCharArray();

		// 출력 형식 저장 배열
		char[][] arr = new char[5][(4 * str.length) + 1];

		char tmp = '#';
		int cnt = 1;

		// 1, 5번쨰줄
		for (int i = 2; i < arr[0].length; i += 4) {

			if (cnt % 3 == 0) {
				tmp = '*';
			}

			arr[0][i] = tmp;
			arr[4][i] = tmp;
			arr[2][i] = str[cnt - 1];

			tmp = '#';
			cnt++;

		}

		tmp = '#';
		cnt = 1;

		// 2, 4번쨰줄
		for (int i = 1; i < arr[0].length; i += 2) {

			if (cnt == 5) {
				tmp = '*';
			}

			arr[1][i] = tmp;
			arr[3][i] = tmp;

			if (cnt == 6) {
				tmp = '#';
				cnt = 0;
			}

			cnt += 1;
		}

		tmp = '#';
		cnt = 1;

		// 3번쨰줄
		for (int i = 0; i < arr[0].length; i += 4) {

			if (cnt % 3 == 0) {
				tmp = '*';

				if (i + 4 < arr[0].length) {

					arr[2][i] = '*';
				} else {
					arr[2][i] = '#';
				}

			}

			if (arr[2][i] == 0) {
				arr[2][i] = tmp;
			} 

			if (cnt % 3 != 0) {
				tmp = '#';
			}
			cnt++;
		}

		for (char[] ar : arr) {
			for (char a : ar) {
				if (a == 0) {
					System.out.print('.');
				} else {
					System.out.print(a);
				}

			}
			System.out.println();
		}

	}
}
