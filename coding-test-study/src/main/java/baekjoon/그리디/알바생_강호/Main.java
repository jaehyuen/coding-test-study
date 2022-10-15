package baekjoon.그리디.알바생_강호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();

		// 줄서있는 사람 리스트
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		// 팁이 높은 순으로 정렬
		Collections.sort(list, Collections.reverseOrder());

		// 받을수있는 팁이 음수가 될때까지 팁계산
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (list.get(i) - i > 0) {
				result += list.get(i) - i;
			} else {
				break;
			}
		}

		System.out.println(result);
	}

}
