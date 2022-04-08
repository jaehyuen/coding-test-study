package baekjoon.브루트포스.차이를_최대로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr1;
	static int[] arr2;
	static boolean[] v;

	static int N;
	static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr1 = new int[N];
		arr2 = new int[N];
		v = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}

		// 브루트 포스로 탐색
		find(0);

		System.out.println(max);

	}

	public static void find(int idx) {

		//순서 배열이 완료되면 값을 구함
		if (N == idx) {

			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(arr2[i] - arr2[i + 1]);
			}

			max = Math.max(sum, max);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				arr2[idx] = arr1[i];
				find(idx + 1);
				v[i] = false;
			}

		}
	}

}
