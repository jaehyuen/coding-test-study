package baekjoon.구현.절사평균;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int             N   = Integer.parseInt(st.nextToken());
		int             K   = Integer.parseInt(st.nextToken());
		double[]        arr = new double[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}

		Arrays.sort(arr);

		int j = N - 1;
		for (int i = 0; i < K; i++) {

			// 보정 평균을 위한 값 변경
			arr[i] = arr[K];
			arr[j] = arr[N - K - 1];
			j--;
		}

		double result1 = 0;
		double result2 = 0;

		for (int i = 0; i < N; i++) {
			if (i >= K && i <= N - K - 1) {
				result1 += arr[i];
			}

			result2 += arr[i];
		}
		// 평균 구하기
		result1 /= N - (2 * K);
		result2 /= N;

		System.out.printf("%.2f\n", Math.round(result1 * 100) / 100d);
		System.out.printf("%.2f\n", Math.round(result2 * 100) / 100d);

	}
}
