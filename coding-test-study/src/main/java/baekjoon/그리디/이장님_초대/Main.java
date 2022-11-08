package baekjoon.그리디.이장님_초대;

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
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 묘묙 정렬
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int result = 0;
		int idx = 1;

		// 걸리는 시간 최대값을 구한다
		for (int i = N - 1; i >= 0; i--) {

			result = Math.max(result, arr[i] + idx);

			idx++;
		}
		System.out.println(result + 1);

	}

}
