package baekjoon.구현.카우버거;

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

		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int min = Math.min(B, C);
		min = Math.min(min, D);

		// 버거
		ArrayList<Integer> list1 = new ArrayList<>();

		// 사이드
		ArrayList<Integer> list2 = new ArrayList<>();

		// 음료
		ArrayList<Integer> list3 = new ArrayList<>();

		int total = 0;
		int tmp = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			tmp = Integer.parseInt(st.nextToken());
			list1.add(tmp);
			total += tmp;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			tmp = Integer.parseInt(st.nextToken());
			list2.add(tmp);
			total += tmp;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < D; i++) {
			tmp = Integer.parseInt(st.nextToken());
			list3.add(tmp);
			total += tmp;
		}

		// 정렬
		Collections.sort(list1, Collections.reverseOrder());
		Collections.sort(list2, Collections.reverseOrder());
		Collections.sort(list3, Collections.reverseOrder());

		// 할인율 계산
		int disCount = 0;
		for (int i = 0; i < min; i++) {
			int a = list1.get(i);
			int b = list2.get(i);
			int c = list3.get(i);

			disCount += (a + b + c) / 10;
		}

		System.out.println(total);
		System.out.println(total - disCount);

	}
}
