package baekjoon.수학.N과M_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static int[] arr1;
	static int[] arr2;
	static boolean[] v;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 조합용 배열 초기화
		arr1 = new int[N];
		arr2 = new int[M];
		v = new boolean[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());

		}

		// 배열 정
		Arrays.sort(arr1);

		find(0, 0);
	}

	public static void find(int idx, int start) {

		// 조합이 완성되면 출력
		if (idx == M) {
			for (int i : arr2) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {

			// 조합에 사용했는지 확인
			if (!v[i]) {
				v[i] = true;
				arr2[idx] = arr1[i];
				find(idx + 1, i + 1);
				v[i] = false;
			}
		}

	}
}
