package baekjoon.그리디.온라인_판매;

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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[M];
		
		//구매 희망 가격 정렬
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		int max = 0;
		int money = 0;
		int idx = M;

		//모든 가격에 대해 게산을 해봄
		for (int i = 0; i < M; i++) {

			int tmp = N > idx ? idx * arr[i] : N * arr[i];

			if (max <= tmp) {
				money = arr[i];
				max = tmp;

			}
			idx--;
		}

		System.out.println(money + " " + max);

	}

}
