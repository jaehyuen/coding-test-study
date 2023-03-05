package baekjoon.그리디.오차_전직;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long[] arr = new long[n];

		st = new StringTokenizer(br.readLine());

		long sum = 0;
		long result = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());

			// 합계 계산
			sum += arr[i];

		}

		// 총 경험치와 활성화 가능한 수를 곱해줌
		result = sum * k;

		// 퀘스트 정렬
		Arrays.sort(arr);

		for (int i = 0; i < k; i++) {

			// 못얻은 경험치를 뺴줌
			result -= arr[i] * (k - i);
		}
		System.out.println(result);
	}
}
