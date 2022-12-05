package baekjoon.브루트포스.회문인_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			// 10 진수 입력
			int num = Integer.parseInt(br.readLine());

			boolean flag = false;

			// 2 ~ 64 진법 계산
			for (int j = 2; j < 65; j++) {

				// 찾았으면 종료
				if (flag) {
					break;
				}
				int tmp = num;

				// 진법 변환
				ArrayList<Integer> list = new ArrayList<>();
				while (tmp != 0) {
					list.add(tmp % j);
					tmp /= j;
				}

				flag = true;

				// 양쪽이 같은지 확인
				for (int k = 0; k < list.size() / 2; k++) {
					if (list.get(k) != list.get(list.size() - 1 - k)) {
						flag = false;
						break;
					}
				}

			}

			if (flag) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}

		}
		System.out.println(sb.toString());

	}

}