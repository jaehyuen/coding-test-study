package baekjoon.DP.신나는_함수_실행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][][] dp = new int[102][102][102];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int             a  = Integer.parseInt(st.nextToken());
			int             b  = Integer.parseInt(st.nextToken());
			int             c  = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1) {
				break;
			}

			System.out.println("w(" + a + ", " + b + ", " + c + ") = " + dfs(a, b, c));

		}

	}

	public static int dfs(int a, int b, int c) {

		if (dp[a + 50][b + 50][c + 50] != 0) {

			return dp[a + 50][b + 50][c + 50];

		} else {

			if (a <= 0 || b <= 0 || c <= 0) {

				dp[a + 50][b + 50][c + 50] = 1;
				return dp[a + 50][b + 50][c + 50];

			} else if (a > 20 || b > 20 || c > 20) {

				dp[a + 50][b + 50][c + 50] = dfs(20, 20, 20);
				return dp[a + 50][b + 50][c + 50];

			} else if (a < b && b < c) {

				dp[a + 50][b + 50][c + 50] = dfs(a, b, c - 1) + dfs(a, b - 1, c - 1) - dfs(a, b - 1, c);
				return dp[a + 50][b + 50][c + 50];

			} else {

				dp[a + 50][b + 50][c + 50] = dfs(a - 1, b, c) + dfs(a - 1, b - 1, c) + dfs(a - 1, b, c - 1)
						- dfs(a - 1, b - 1, c - 1);
				return dp[a + 50][b + 50][c + 50];

			}

		}

	}

}
