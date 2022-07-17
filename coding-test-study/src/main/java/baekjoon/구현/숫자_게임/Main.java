package baekjoon.구현.숫자_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int max = 0;
		int maxIdx = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[5];

			// i번 사람의 카드 입력
			for (int j = 0; j < 5; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			// 모든 경우의 수를 파악한다
			for (int a = 0; a < 5; a++) {
				for (int b = a + 1; b < 5; b++) {
					for (int c = b + 1; c < 5; c++) {

						int tmp = (arr[a] + arr[b] + arr[c]) % 10;

						// 최대값 업데이트
						if (tmp >= max) {
							max = tmp;
							maxIdx = i + 1;
						}
					}
				}
			}
		}

		System.out.println(maxIdx);

	}

}
