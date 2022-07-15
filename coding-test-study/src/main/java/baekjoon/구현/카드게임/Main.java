package baekjoon.구현.카드게임;

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

		BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));

		int[]          arr1 = new int[4];
		int[]          arr2 = new int[10];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st    = new StringTokenizer(br.readLine());

			String          color = st.nextToken();
			int             num   = Integer.parseInt(st.nextToken());

			if (color.equals("R")) {
				arr1[0]++;
			} else if (color.equals("B")) {
				arr1[1]++;
			} else if (color.equals("Y")) {
				arr1[2]++;
			} else if (color.equals("G")) {
				arr1[3]++;
			}

			arr2[num]++;
		}

		if (arr1[0] == 5 || arr1[1] == 5 || arr1[2] == 5 || arr1[3] == 5) {
			// 1번 조건
			boolean flag = false;
			int     max  = 0;
			int     cnt  = 0;

			// 숫자가 연속적인지 체크
			for (int i = 1; i < 10; i++) {

				if (!flag && arr2[i] == 1) {
					cnt++;
					flag = true;
				} else if (flag && cnt < 5) {
					if (arr2[i] == 1) {
						max = i;
						cnt++;
						flag = true;
					} else {
						flag = false;
						break;
					}
				}

			}

			if (flag && cnt == 5) {
				System.out.println(900 + max);
				return;
			}
		}

		for (int i = 1; i < 10; i++) {
			// 2번 조건
			if (arr2[i] == 4) {
				System.out.println(800 + i);
				return;
			}

			for (int j = 1; j < 10; j++) {
				// 3번 조건
				if (arr2[i] == 3 && arr2[j] == 2) {
					System.out.println(700 + j + (i * 10));
					return;
				}
			}
		}

		// 4번쨰 조건
		if (arr1[0] == 5 || arr1[1] == 5 || arr1[2] == 5 || arr1[3] == 5) {
			int max = 0;
			for (int i = 1; i < 10; i++) {
				if (arr2[i] != 0) {
					max = i;
				}

			}
			System.out.println(600 + max);
			return;
		}

		// 5번쨰 조건
		boolean flag = false;
		int     max  = 0;
		int     cnt  = 0;

		// 숫자가 연속적인지 체크
		for (int i = 1; i < 10; i++) {

			if (!flag && arr2[i] == 1) {
				cnt++;
				flag = true;
			} else if (flag && cnt < 5) {
				if (arr2[i] == 1) {
					max = i;
					cnt++;
					flag = true;
				} else {
					flag = false;
					break;
				}
			}

		}

		if (flag && cnt == 5) {
			System.out.println(500 + max);
			return;
		}

		for (int i = 1; i < 10; i++) {
			// 6번쨰 조건
			if (arr2[i] == 3) {
				System.out.println(400 + i);
				return;
			}
			for (int j = 1; j < 10; j++) {
				// 7번쨰 조건
				if (arr2[i] == 2 && arr2[j] == 2 && i != j) {
					System.out.println(300 + i + (j * 10));
					return;
				}
			}
		}

		for (int i = 1; i < 10; i++) {
			// 8번쨰 조건
			if (arr2[i] == 2) {
				System.out.println(200 + i);
				return;
			}
		}

		for (int i = 9; i > 0; i--) {
			// 9번쨰 조건
			if (arr2[i] != 0) {
				System.out.println(100 + i);
				return;
			}
		}

	}

}
