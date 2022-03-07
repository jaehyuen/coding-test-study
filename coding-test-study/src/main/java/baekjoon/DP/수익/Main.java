package baekjoon.DP.수익;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int N = Integer.parseInt(br.readLine());
			int max = Integer.MIN_VALUE;

			// 0이 들어오기 전까지 반복문 걔속
			if (N == 0) {
				break;
			}

			// dp 배열 선언
			int[] dp = new int[N];

			// 수익을 입력 받으며 최대 수익을 저장한다
			for (int i = 0; i < N; i++) {

				int tmp = Integer.parseInt(br.readLine());

				// 첫번쨰 날은 첫번째 수익이 최대
				if (i == 0) {
					dp[i] = tmp;
				} else {
					// 두번째 날부터는 전날 최대수익+오늘수익, 오늘수익 둘중 수익이 큰날이 답
					dp[i] = Math.max(dp[i - 1] + tmp, tmp);
				}
				//최대값 갱신
				max = Math.max(max, dp[i]);
			}

			System.out.println(max);
		}

	}
}