package baekjoon.구현.연산자_끼워넣기_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int[] arr2;

	static int max = Integer.MAX_VALUE * -1;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		arr2 = new int[4];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());

		}

		sum(1, arr[0], arr2[0], arr2[1], arr2[2], arr2[3]);
		System.out.println(max);
		System.out.println(min);

	}

	public static void sum(int depth, int sum, int tmp1, int tmp2, int tmp3, int tmp4) {

		if (depth == N) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		if (tmp1 > 0) {
			sum(depth + 1, sum + arr[depth], tmp1 - 1, tmp2, tmp3, tmp4);
		}
		if (tmp2 > 0) {
			sum(depth + 1, sum - arr[depth], tmp1, tmp2 - 1, tmp3, tmp4);
		}
		if (tmp3 > 0) {
			sum(depth + 1, sum * arr[depth], tmp1, tmp2, tmp3 - 1, tmp4);
		}
		if (tmp4 > 0) {
			sum(depth + 1, sum / arr[depth], tmp1, tmp2, tmp3, tmp4 - 1);
		}

	}

}
