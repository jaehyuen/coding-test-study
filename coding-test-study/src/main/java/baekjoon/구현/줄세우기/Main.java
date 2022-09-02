package baekjoon.구현.줄세우기;

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

		int            N    = Integer.parseInt(br.readLine());

		String[]       arr1 = new String[N];
		String[]       arr2 = new String[N];

		// 이름 입력
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			arr1[i] = tmp;
			arr2[i] = tmp;
		}

		// 기준이될 배열을 정렬

		Arrays.sort(arr2);

		boolean flag = true;

		for (int i = 0; i < N; i++) {

			if (!arr1[i].equals(arr2[i])) {
				flag = false;
				break;
			}

		}

		// 오름차순
		if (flag) {
			System.out.println("INCREASING");
			return;
		}

		int j = N - 1;
		flag = true;

		for (int i = 0; i < N; i++) {

			if (!arr1[i].equals(arr2[j])) {
				flag = false;
				break;
			}
			j--;

		}

		// 내림차순
		if (flag) {
			System.out.println("DECREASING");
		} else {
			// 모름
			System.out.println("NEITHER");
		}

	}
}
