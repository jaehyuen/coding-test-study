package baekjoon.구현.나무_조각;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static String[] test;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (true) {

			// 1 ~ 4번 조건
			for (int i = 0; i < 4; i++) {
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;

					// 순서가 바뀌면 출력
					for (int j = 0; j < 5; j++) {
						System.out.print(arr[j] + " ");
					}
					System.out.println();
				}
			}

			boolean flag = true;

			// 5번 조건 확인
			for (int i = 0; i < 5; i++) {
				if (arr[i] != i + 1) {
					flag = false;
					break;
				}

			}
			// 정렬됫으면 종료
			if (flag) {
				return;
			}

		}

	}
}
