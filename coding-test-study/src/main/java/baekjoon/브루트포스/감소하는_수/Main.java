package baekjoon.브루트포스.감소하는_수;

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

	static ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 10 이하는 N이다
		if (N < 10) {
			System.out.println(N);
		} else if (N > 1022) {
			// 감소하는 수의 갯수는 1022개이다
			System.out.println("-1");
		} else {
			for (int i = 0; i < 10; i++) {
				find(1, i);
			}

			// 찾은 숫자를 정렬
			Collections.sort(list);
			System.out.println(list.get(N));
		}
	}

	public static void find(int idx, long num) {
		// 숫자를 다 썻으면 초기화
		if (idx > 10) {
			return;
		}
		list.add(num);

		// 마지막 자리보다 숫자가 낮은거만 돌린다
		for (int i = 0; i < num % 10; i++) {
			find(idx + 1, (num * 10) + i);
		}

	}

}