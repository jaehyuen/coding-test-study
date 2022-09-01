package baekjoon.구현.소가_길을_건너간_이유_2;

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

		BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));

		// 시작점
		int[]          start = new int[26];

		// 끝나는점
		int[]          end   = new int[26];

		char[]         arr   = br.readLine()
			.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			int tmp = arr[i] - 'A';

			// 시작점, 끝점 설정
			if (start[tmp] == 0) {
				start[tmp] = i + 1;
			} else {
				end[tmp] = i + 1;
			}
		}

		int cnt = 0;

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {

				// 겹치면 카운트 증가
				if (start[i] < start[j] && start[j] < end[i] && end[i] < end[j])
					cnt++;

			}
		}

		System.out.println(cnt);

	}
}
