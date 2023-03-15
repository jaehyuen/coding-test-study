package baekjoon.그리디.F7;

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

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 마지막 점수 정렬
		Arrays.sort(arr);

		// 최대값은 최고 점수를 받은 선수 (현재 꼴등)
		int max = arr[N - 1] + 1;

		// 최고 점수를 받은 선수는 무조건 1등이 가능하므로 1로 시작
		int cnt = 1;
		int j = 1;

		for (int i = N - 2; i >= 0; i--) {

			// 현재 선수가 1등했을떄 기존 점수보다 크거나 같으면 1등 가능
			if (arr[i] + N >= max) {
				cnt++;
			}

			// 꼴등값 갱신
			max = Math.max(max, arr[i] + j + 1);

			// 인덱스 증가
			j++;
		}
		System.out.println(cnt);

	}

}
