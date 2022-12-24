package baekjoon.구현.이차원_배열과_연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[3][3];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;

		while (true) {

			// 범위 체크
			if (r - 1 < arr.length && c - 1 < arr[0].length) {
				if (arr[r - 1][c - 1] == k) {
					break;
				}
			}

			// 100초가 넘어가면 그만
			if (cnt >= 100) {
				System.out.println(-1);
				return;
			}
			cnt++;

			if (arr.length >= arr[0].length) {
				// R연산
				int xLen = arr.length;
				int yLen = 0;

				ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();

				for (int[] ar : arr) {
					HashMap<Integer, Integer> map = new HashMap<>();

					// 숫자 카운팅
					for (int a : ar) {
						if (a != 0) {
							map.put(a, map.getOrDefault(a, 0) + 1);
						}

					}

					// 배열 최대 길이 구하기
					yLen = Math.max(yLen, map.size() * 2);

					// 리스트에 추가
					list.add(map);
				}

				// 길이가 100 넘어가는지 체크
				yLen = yLen > 100 ? 100 : yLen;
				arr = new int[xLen][yLen];

				// 배열 그리기
				for (int i = 0; i < xLen; i++) {

					// 맵을 리스트로 변환하여 꺼내옴
					ArrayList<Map.Entry<Integer, Integer>> sortedList = new ArrayList<Map.Entry<Integer, Integer>>(
							list.get(i).entrySet());

					Collections.sort(sortedList, (o1, o2) -> {

						if (o1.getValue() == o2.getValue()) {
							return o1.getKey() - o2.getKey();
						}
						return o1.getValue() - o2.getValue();
					});

					int j = 0;

					for (Map.Entry<Integer, Integer> now : sortedList) {

						// 길이가 100 넘어가면 종료
						if (j >= 100) {
							break;
						}

						arr[i][j] = now.getKey();
						arr[i][j + 1] = now.getValue();
						j += 2;
					}

				}

			} else {
				// C연산
				int xLen = 0;
				int yLen = arr[0].length;

				ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();

				for (int i = 0; i < arr[0].length; i++) {

					HashMap<Integer, Integer> map = new HashMap<>();

					// 숫자 카운팅
					for (int j = 0; j < arr.length; j++) {
						if (arr[j][i] != 0) {
							map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
						}
					}

					// 배열 최대 길이 구하기
					xLen = Math.max(xLen, map.size() * 2);

					// 리스트에 추가
					list.add(map);
				}

				// 길이가 100 넘어가는지 체크
				xLen = xLen > 100 ? 100 : xLen;
				arr = new int[xLen][yLen];

				// 배열 그리기
				for (int i = 0; i < yLen; i++) {

					// 맵을 리스트로 변환하여 꺼내옴
					ArrayList<Map.Entry<Integer, Integer>> sortedList = new ArrayList<Map.Entry<Integer, Integer>>(
							list.get(i).entrySet());

					Collections.sort(sortedList, (o1, o2) -> {

						if (o1.getValue() == o2.getValue()) {
							return o1.getKey() - o2.getKey();
						}
						return o1.getValue() - o2.getValue();
					});

					int j = 0;

					for (Map.Entry<Integer, Integer> now : sortedList) {

						// 길이가 100 넘어가면 종료
						if (j >= 100) {
							break;
						}

						arr[j][i] = now.getKey();
						arr[j + 1][i] = now.getValue();
						j += 2;
					}

				}
			}

		}

		System.out.println(cnt);

	}
}
