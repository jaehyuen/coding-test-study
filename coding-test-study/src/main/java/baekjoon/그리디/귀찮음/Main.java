package baekjoon.그리디.귀찮음;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long total = 0;

		// 쇠 막대 정렬
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}

		// 정렬
		Arrays.sort(arr);

		// 짧은거부터 짤라준다
		long result = 0;
		for (int i = 0; i < N - 1; i++) {

			total -= arr[i];
			result += arr[i] * total;

		}

		System.out.println(result);

	}

}
