package baekjoon.DP.기타리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] v = new int[N];

		// 가능한 볼륨인지 체크하는 배열
		boolean[][] dp = new boolean[101][1001];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}

		// 초기값 세팅
		if (S - v[0] >= 0)
			dp[0][S - v[0]] = true;
		
		if (S + v[0] <= M)
			dp[0][S + v[0]] = true;

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j <= M; j++) {

				// 해당 볼륨은 불가능하다면 컨티뉴
				if (!dp[i][j])
					continue;

				// 가능한지 체크
				if (j - v[i + 1] >= 0) {
					dp[i + 1][j - v[i + 1]] = true;
				}
				if (j + v[i + 1] <= M) {
					dp[i + 1][j + v[i + 1]] = true;
				}
			}
		}

		int result = -1;

		// 최대 볼륨까지 반복
		for (int i = 0; i <= M; i++) {
			if (dp[N - 1][i] && result < i) {
				result = i;
			}

		}

		System.out.println(result);
	}

}
