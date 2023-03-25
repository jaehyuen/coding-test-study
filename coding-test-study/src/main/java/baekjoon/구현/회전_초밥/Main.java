package baekjoon.구현.회전_초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		// 초밥 종류 모음집
		HashMap<Integer, Integer> map = new HashMap<>();

		// 쿠폰 초밥을 넣어줌
		map.put(c, 1);

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i < k) {
				map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			}
		}
		int start = 0;
		int end = k - 1;
		int max = map.size();

		for (int i = 1; i < N; i++) {
			start++;
			end++;

			// 뒷쪽 커서가 범위를 넘어가면 0으로 초기화
			if (end >= N) {
				end = 0;
			}

			// 이전 순서의 맨 처음 초밥을 가져운다
			int tmp = map.get(arr[start - 1]);

			// 1개만 먹었으면 모음집에서 지움
			if (tmp == 1) {
				map.remove(arr[start - 1]);
			} else {
				map.put(arr[start - 1], tmp - 1);
			}

			// 새로운 초밥 추가
			map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
			max = Math.max(max, map.size());
			// System.out.println(start + ", " + end + " : " + map);
		}
		System.out.println(max);

	}
}
