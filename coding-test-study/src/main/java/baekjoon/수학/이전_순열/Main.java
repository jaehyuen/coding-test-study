package baekjoon.수학.이전_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}

		if (find()) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println(-1);
		}

	}

	public static boolean find() {
		int i = N - 1;
		int j = N - 1;

		// i - 1 이 i보다 클때까지 반복
		while (i > 0 && arr[i - 1] < arr[i])
			i--;

		// i가 0이면 이전 순열이 없다
		if (i == 0)
			return false;

		// i - 1 이 j보다 클때까지 반복
		while (i > 0 && arr[i - 1] < arr[j])
			j--;

		// i - 1, j 스왑
		int tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;
		N--;

		// i 부터 끝까지 정렬
		while (i < N) {
			tmp = arr[i];
			arr[i] = arr[N];
			arr[N] = tmp;

			i++;
			N--;

		}
		return true;
	}
}
