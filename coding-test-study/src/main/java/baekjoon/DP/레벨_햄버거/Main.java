package baekjoon.DP.레벨_햄버거;

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
		long X = Long.parseLong(st.nextToken());

		// dp[i][0] = 햄버거 전체 길이
		// dp[i][1] = 햄버거의 패티 갯수
		long[][] dp = new long[N + 1][2];
		dp[0][0] = 1;
		dp[0][1] = 1;

		for (int i = 1; i <= N; i++) {
			dp[i][0] = (dp[i - 1][0] * 2) + 3;
			dp[i][1] = (dp[i - 1][1] * 2) + 1;
		}
		System.out.println(find(dp, N, X));

	}

	public static long find(long[][] dp, int n, long x) {

		if (dp[n][0] == x) {

			// 길이가 현재 버거의 길이와 같으면 패티 캣수 리턴
			return dp[n][1];
		} else if (x == 1) {

			// 길이가 1개면 빵이기에 0 리턴
			return 0;
		}

		// 버거 중간값
		long tmp = dp[n][0] / 2;

		if (tmp + 1 == x) {

			// 버거의 반에 중간 패티를 합한 길이
			return dp[n - 1][1] + 1;
		} else if (tmp >= x) {

			// 버거의 반보다 작으면 n-1 버거로 범위를 줄여서 패티를 찾음
			return find(dp, n - 1, x - 1);
		} else {

			// 버거의 반보다 크면 그 반의 패티 갯수와 남는 길이를 구함
			return dp[n - 1][1] + 1 + find(dp, n - 1, x - tmp - 1);
		}

	}
}