package baekjoon.DP.이름_궁합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		// 알파벳 획수 초기화
		int[] arr1 = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] cArr1 = br.readLine().toCharArray();
		char[] cArr2 = br.readLine().toCharArray();

		// dp배열 초기화
		int[][] dp = new int[cArr1.length * 2 - 1][cArr1.length * 2];

		int tmp = 0;

		// 첫번째 초기화
		for (int i = 0; i < cArr1.length; i++) {

			dp[0][tmp] = arr1[cArr1[i] - 'A'];
			dp[0][tmp + 1] = arr1[cArr2[i] - 'A'];

			tmp += 2;
		}

		// 이름 궁합 계산
		tmp = cArr1.length * 2 - 1;
		for (int i = 1; i < cArr1.length * 2 - 1; i++) {
			for (int j = 0; j < tmp; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1]) % 10;
			}
			tmp--;
		}

		System.out.println(dp[dp.length - 1][0] + "" + dp[dp.length - 1][1]);

	}
}