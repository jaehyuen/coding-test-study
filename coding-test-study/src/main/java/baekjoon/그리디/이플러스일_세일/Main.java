package baekjoon.그리디.이플러스일_세일;

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

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 가격순으로 정렬
		Arrays.sort(arr);

		int tmp = 0;
		int total = 0;
		int min = Integer.MAX_VALUE;

		for (int i = arr.length - 1; i >= 0; i--) {
			tmp++;
			total += arr[i];
			min = Math.min(arr[i], min);

			// 3개를 삿으면 가장 저렴한값을 할인
			if (tmp == 3) {
				tmp = 0;
				total -= min;
				min = Integer.MAX_VALUE;
			}
		}

		System.out.println(total);
	}

}
