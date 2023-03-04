package baekjoon.그리디.민겸_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		int cnt = 0;

		StringBuilder max = new StringBuilder();
		StringBuilder min = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {

			// 문자 M 카운팅
			if (arr[i] == 'M') {
				cnt++;
			} else {

				// 최대값은 맨처음 5 이후 cnt개 만큼 0을 붙
				// 최소값은 맨처음 1 이후 cnt - 1개 만큼 0을 붙이고 마지막에 5을 붙임
				for (int j = 0; j < cnt; j++) {
					if (j == 0) {
						max.append(5);
						min.append(1);
					} else {
						max.append(0);
						min.append(0);
					}

				}

				// K가 연속적으로 있다면 그냥 5를 붙임
				if (cnt == 0) {
					max.append(5);
					min.append(5);
				} else {
					max.append(0);
					min.append(5);
				}

				cnt = 0;

			}

		}
		
		// 최대값은 맨처음 5 이후 cnt개 만큼 0을 붙
		// 최소값은 맨처음 1 이후 cnt - 1개 만큼 0을 붙이고 마지막에 5을 붙임
		for (int j = 0; j < cnt; j++) {
			if (j == 0) {
				max.append(1);
				min.append(1);
			} else {
				max.append(1);
				min.append(0);
			}

		}

		System.out.println(max.toString());
		System.out.println(min.toString());

	}

}
