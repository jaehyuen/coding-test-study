package baekjoon.이분탐색.공유기_설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static int N;
	public static int C;

	public static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		// 집간 최대 거리를 구한다
		int end = arr[N - 1] - arr[0] + 1;
		int start = 1;

		while (end > start) {
			int mid = (start + end) / 2;

			if (check(mid)) {
				end = mid;
			} else {
				start = mid + 1;

			}
		}
		System.out.println(end - 1);

	}

	public static boolean check(int distance) {
		int cnt = 1;
		int idx = arr[0];

		for (int i = 1; i < N; i++) {

			// 현재거리(최소) 마다 공유기를 구성한다
			if (arr[i] - idx >= distance) {
				cnt++;
				idx = arr[i];
			}
		}

		// 설치 갯수가 부족하면 해당 거리로는 설치가 불가능 하다
		// 갯수가 넘어가면 무조건 가능하다
		if (cnt < C) {
			return true;
		} else {
			return false;
		}

	}

}
