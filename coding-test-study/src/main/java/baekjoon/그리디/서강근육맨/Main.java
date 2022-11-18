package baekjoon.그리디.서강근육맨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 근손실량 정렬
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		long max = 0;

		// 운동기구 갯수가 짝수면 날마다 순서대로 근손실이 가장 크고 기구로 운동
		if (N % 2 == 0) {

			int j = N - 1;

			for (int i = 0; i < N / 2; i++) {
				max = Math.max(max, arr[i] + arr[j]);
				j--;
			}

		} else {

			// 운동기구 갯수가 홀수면 가장 근손실이 큰건 마지막날하고 나머지는 위와 동일
			max = arr[N - 1];
			int j = N - 2;

			for (int i = 0; i < N / 2; i++) {
				max = Math.max(max, arr[i] + arr[j]);
				j--;
			}
		}

		System.out.println(max);

	}

}
