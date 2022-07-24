package baekjoon.구현.숫자_빈도수;

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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		if (n < 10) {
			System.out.println(1);
			return;

		} else {

			int[] arr = new int[10];

			for (int i = 10; i <= n; i++) {

				char[] cArr = String.valueOf(i).toCharArray();
				for (char c : cArr) {
					// 빈도수 추가
					arr[c - '0']++;
				}
			}

			// 빈도수에 + 1 해서 출력해준다
			System.out.println(arr[d] + 1);
			return;
		}

	}

}
