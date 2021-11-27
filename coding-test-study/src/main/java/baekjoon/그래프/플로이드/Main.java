package baekjoon.그래프.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n + 1][n + 1];

		int INF = 987654321;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = INF;
				if (i == j) {
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			int tmp3 = Integer.parseInt(st.nextToken());

			arr[tmp1][tmp2] = Math.min(tmp3, arr[tmp1][tmp2]);
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);

				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(arr[i][j] == INF ? 0 + " " : arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}
