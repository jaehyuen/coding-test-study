package baekjoon.그리디.나무_자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int             n   = Integer.parseInt(br.readLine());

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		long            sum = 0;
		int[]           arr = new int[n];
		for (int i = 0; i < n; i++) {
			int H = Integer.parseInt(st1.nextToken());
			int A = Integer.parseInt(st2.nextToken());

			arr[i]  = A;

			// 결국 모든 나무를 한번씩 자르기 떄문에 미리 현재 길이를 더해준다
			sum    += H;
		}

		// 성장률 순으로 정렬
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {

			// 자라난 값을 더해줌
			sum += arr[i] * i;
		}
		System.out.println(sum);

	}

}
