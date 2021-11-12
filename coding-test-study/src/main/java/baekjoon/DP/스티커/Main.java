package baekjoon.DP.스티커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int             T  = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			int     n   = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n + 2];

			for (int k = 0; k < 2; k++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[k][j] = Integer.parseInt(st.nextToken());
				}
			}

			arr[0][0] = arr[0][0];
			arr[1][0] = arr[1][0];

			arr[0][1] = arr[1][0] + arr[0][1];
			arr[1][1] = arr[0][0] + arr[1][1];

			for (int j = 2; j < n; j++) {
				arr[0][j] = Math.max(arr[1][j - 1], arr[1][j - 2]) + arr[0][j];
				arr[1][j] = Math.max(arr[0][j - 1], arr[0][j - 2]) + arr[1][j];
			}

			System.out.println(Math.max(arr[0][n - 1], arr[1][n - 1]));

		}

	}

}
