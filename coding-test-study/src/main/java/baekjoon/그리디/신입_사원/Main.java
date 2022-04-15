package baekjoon.그리디.신입_사원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 갯수 입력
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			// 신입사원 수 입력
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][2];

			// 신입사원 점수 입력
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}

			// 신입사원 1차 점수로 정렬
			Arrays.sort(arr, (o1, o2) -> {
				return o1[0] - o2[0];
			});

			int min = arr[0][1];
			int cnt = 1;

			// 합격자만 카운트
			for (int j = 0; j < N; j++) {
				if (arr[j][1] < min) {
					cnt++;
					min = arr[j][1];
				}

			}

			System.out.println(cnt);

		}
	}

}
