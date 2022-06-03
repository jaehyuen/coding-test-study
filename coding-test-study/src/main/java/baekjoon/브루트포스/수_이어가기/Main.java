package baekjoon.브루트포스.수_이어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> maxList = new ArrayList<>();

		for (int i = N; i >= 0; i--) {

			ArrayList<Integer> list = new ArrayList<>();

			// 1, 2번쨰 수를 담는다
			list.add(N);
			list.add(i);

			while (true) {

				// 조건을 확인하고 수를 담는다
				int now = list.size() - 1;

				now = list.get(now - 1) - list.get(now);

				if (now < 0) {
					break;
				}
				list.add(now);

			}

			// 최대값 체크 및 변경
			if (maxList.size() < list.size()) {
				maxList = list;

			}

		}
		System.out.println(maxList.size());
		for (int i : maxList) {
			System.out.print(i + " ");
		}

	}

}