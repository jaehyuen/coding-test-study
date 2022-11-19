package baekjoon.그리디.사탕;

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
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int J = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				int R = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());

				// 최대 과자 갯수를 배열에 넣음
				arr[j] = R * C;

			}

			// 배열 정렬
			Arrays.sort(arr);
			int cnt = 0;

			for (int j = N - 1; j >= 0; j--) {

				// 사탕 포장
				J -= arr[j];
				cnt++;

				// 포장 완료시 반복 종료
				if (J <= 0) {
					break;
				}

			}

			System.out.println(cnt);

		}
	}

}
