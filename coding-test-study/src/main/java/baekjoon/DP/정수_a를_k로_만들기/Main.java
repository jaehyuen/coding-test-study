package baekjoon.DP.정수_a를_k로_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dp = new int[K + 1];

		// A에서부터 하나씩 체크
		for (int i = A + 1; i <= K; i++) {

			// i - 1 위치의 값에서 1연산을한 갯수 증가
			dp[i] = dp[i - 1] + 1;

			if (i - A >= A && i % 2 == 0) {
				// i가 최소 A의 2배 이며 짝수일때 2연산이 가능하다
				// 1, 2연산중 최소값을 저장
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
		}

		System.out.println(dp[K]);

	}
}